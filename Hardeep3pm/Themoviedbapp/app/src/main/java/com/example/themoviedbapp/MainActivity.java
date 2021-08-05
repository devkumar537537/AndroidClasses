package com.example.themoviedbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.themoviedbapp.models.ProductionCompany;
import com.example.themoviedbapp.models.Root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView inofone,inofotwo;
ApiServices apiServices;
ArrayList<ProductionCompany> arrayList;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        inofone = findViewById(R.id.infoone);
        inofotwo = findViewById(R.id.inoftwo);
        imageView = findViewById(R.id.imageview);
        apiServices = ApiClient.getRetrofit().create(ApiServices.class);

Call<Root> call = apiServices.getresponsee();

call.enqueue(new Callback<Root>() {
    @Override
    public void onResponse(Call<Root> call, Response<Root> response) {
        if(!response.isSuccessful())
        {
            Toast.makeText(MainActivity.this, "error "+response.code(), Toast.LENGTH_SHORT).show();
            return;
        }
        Root root = response.body();
        inofone.setText(root.getOverview());
StringBuilder stringBuilder = new StringBuilder();
        for(ProductionCompany productionCompany : root.production_companies)
        {
            stringBuilder.append("id => "+productionCompany.getId()+"\n");
            stringBuilder.append("name => "+productionCompany.getName()+"\n");
            stringBuilder.append("country => "+productionCompany.getOrigin_country()+"\n\n");
            arrayList.add(productionCompany);
        }
        inofotwo.setText(stringBuilder.toString());
//        Glide.with(getApplicationContext()).load(arrayList.get(1).logo_path).into(imageView);
    }

    @Override
    public void onFailure(Call<Root> call, Throwable t) {
        Toast.makeText(MainActivity.this, "error "+t.getMessage(), Toast.LENGTH_SHORT).show();

    }
});

    }
}