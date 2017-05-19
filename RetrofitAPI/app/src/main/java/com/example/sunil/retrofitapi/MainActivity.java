package com.example.sunil.retrofitapi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sunil.retrofitapi.Adapter.FlowerAdapter;
import com.example.sunil.retrofitapi.Controller.RestManager;
import com.example.sunil.retrofitapi.model.Flowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.process;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RestManager restManager;
    private FlowerAdapter flowerAdapter;
    private  ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //config();
        restManager = new RestManager();
       progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        Call<List<Flowers>> listCall = restManager.getFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flowers>>() {
            @Override
            public void onResponse(Call<List<Flowers>> call, Response<List<Flowers>> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    List<Flowers> flowersList = response.body();
                    config(flowersList);
                } else {
                    int sc = response.code();

                }
            }

            @Override
            public void onFailure(Call<List<Flowers>> call, Throwable t) {

            }
        });


    }

    public void config(List<Flowers> flowers) {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        flowerAdapter = new FlowerAdapter();
        flowerAdapter.refresh(flowers);
        recyclerView.setAdapter(flowerAdapter);


    }
}
