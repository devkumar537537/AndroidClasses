package com.dailydose.lifehackes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class FavriotQuotesActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Model> options;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    ProgressBar progressBar;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favriot_quotes);

// set the drawable as progress drawable
        toolbar = findViewById(R.id.favroitToolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.toolbar_progress_bar);
        toolbar.setTitle("Motivational Quotes Images");
        toolbar.setTitleTextAppearance(this, R.style.RobotoBoldTextAppearance);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        firebaseDatabase = FirebaseDatabase.getInstance();
        recyclerView = findViewById(R.id.favroitRecyclerView);
        databaseReference = firebaseDatabase.getReference("Data");

        showData();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adViewQuotesImages);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener()
                              {
                                  @Override
                                  public void onAdLoaded() {
                                      super.onAdLoaded();
                                      mAdView.setVisibility(View.VISIBLE);
                                  }
                              }
        );
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    private void showData() {
        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(databaseReference, Model.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Model model) {
                holder.setDetails(getApplicationContext(), model.getImage());
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListner(new ViewHolder.Clicklistner() {
                    @Override
                    public void onItemClick(View view, int position, final String url) {

                        Intent intent = new Intent(FavriotQuotesActivity.this, FullScreenImage.class);
                        intent.putExtra("url", url);
                        intent.putExtra("position", position);
                        startActivity(intent);
                        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                    }
                });
                progressBar.setVisibility(View.GONE);
                return viewHolder;

            }
        };

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);


    }


    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseRecyclerAdapter != null) {
            firebaseRecyclerAdapter.startListening();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in_backpress, R.anim.push_down_out_backpress);
    }
}