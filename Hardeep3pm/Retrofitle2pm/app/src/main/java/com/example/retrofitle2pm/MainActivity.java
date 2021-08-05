package com.example.retrofitle2pm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView textView;
ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.datavalues);

        apiServices = Apiclent.getRetrofit().create(ApiServices.class);


//getpost();
        createpost();

    }

    private void createpost() {
        Call<Creadtresponse> calllist = apiServices.getPsotWithField("It is testing","It is body");

        calllist.enqueue(new Callback<Creadtresponse>() {
            @Override
            public void onResponse(Call<Creadtresponse> call, Response<Creadtresponse> response) {
                Creadtresponse creadtresponse = response.body();

                Toast.makeText(MainActivity.this, "message "+creadtresponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Creadtresponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error" +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getpost() {
        ArrayList<DataModel> arrayList = new ArrayList<>();

        Call<ArrayList<DataModel>> arrayListCall = apiServices.getPostList();
        arrayListCall.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                if(!response.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "error"+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for(DataModel dataModel: response.body())
                {
                    arrayList.add(dataModel);


                    stringBuilder.append(" id: =>"+dataModel.getId()+"\n");
                    stringBuilder.append("titole: => "+dataModel.getTitle()+"\n");
                    stringBuilder.append("body: =>" + dataModel.getBody()+"\n");
                    stringBuilder.append("creted: =>"+dataModel.getCreated()+"\n\n");
                }
                textView.setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "eroro "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}