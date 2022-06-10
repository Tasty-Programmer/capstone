package com.obyte.alcohol.Rest;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private final static String SERVICE_KEY = "PiupwYl4E3qXUITudPuqSalNK8/yzD8jOUgFtMIZJkEB2CPsZaDBfae+UAU9MoNKBJLvaUxIlq5jY2WwzDmEeg==";

    public static ArrayList<DrinkData> connect(String url) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServerService serverService = retrofit.create(ServerService.class);
        Call<PageData> call = serverService.getTestData(1, 100, SERVICE_KEY);
        //Call<PageData> call = serverService.getData();

        PageData pageData = call.execute().body();

        return pageData.getData();
    }
}
