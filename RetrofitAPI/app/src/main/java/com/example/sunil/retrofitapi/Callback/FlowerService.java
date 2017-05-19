package com.example.sunil.retrofitapi.Callback;

import com.example.sunil.retrofitapi.model.Flowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sunil on 19/05/17.
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flowers>> getAllFlowers();
}
