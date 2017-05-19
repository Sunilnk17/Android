package com.example.sunil.retrofitapi.Controller;

import android.provider.SyncStateContract;

import com.example.sunil.retrofitapi.Callback.FlowerService;
import com.example.sunil.retrofitapi.Helper.Constants;
import com.example.sunil.retrofitapi.model.Flowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by sunil on 19/05/17.
 */

public class RestManager  {

    private FlowerService flowerService;

    public FlowerService getFlowerService(){
        if(flowerService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            flowerService = retrofit.create(FlowerService.class);
        }
       return flowerService;

    }



}
