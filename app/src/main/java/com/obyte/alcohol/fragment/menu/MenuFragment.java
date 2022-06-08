package com.obyte.alcohol.fragment.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.obyte.alcohol.R;
import com.obyte.alcohol.Rest.DrinkData;
import com.obyte.alcohol.Rest.PageData;
import com.obyte.alcohol.Rest.ServerService;
import com.obyte.alcohol.ViewAdepter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuFragment extends Fragment {

    public MenuFragment(){

    }

    RecyclerView rvLists;
    ArrayList<DrinkData> dataArrayList;
    ViewAdepter viewAdepter;

    final static String BASE_URL = "https://api.odcloud.kr/api/";
    final static String SERVICE_KEY = "PiupwYl4E3qXUITudPuqSalNK8/yzD8jOUgFtMIZJkEB2CPsZaDBfae+UAU9MoNKBJLvaUxIlq5jY2WwzDmEeg==";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_menu,container,false);
        init(viewGroup);

        dataArrayList = new ArrayList<>();
        viewAdepter = new ViewAdepter(dataArrayList, getContext());
        
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvLists.setLayoutManager(linearLayoutManager);
        rvLists.setAdapter(viewAdepter);

        serverConnect();

        return viewGroup;
    }


    public void init(ViewGroup viewGroup) {
        rvLists = viewGroup.findViewById(R.id.rvLists);
    }

    public void serverConnect(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServerService serverService = retrofit.create(ServerService.class);
        Call<PageData> call = serverService.getData(1, 100, SERVICE_KEY);

        call.enqueue(new Callback<PageData>() {
            @Override
            public void onResponse(Call<PageData> call, Response<PageData> response) {
                if (response.isSuccessful()) {
                    int beforeListSize = viewAdepter.getItemCount();
                    ArrayList<DrinkData> responseDatas = response.body().getData();
                    Log.i("size", beforeListSize + " ");

                    dataArrayList.addAll(responseDatas);

                    viewAdepter.notifyItemRangeInserted(viewAdepter.getItemCount(), responseDatas.size());
                    Log.i("size", viewAdepter.getItemCount() + " ");

                }else{
                    String errorMessage = null;
                    try{
                        errorMessage =response.errorBody().string();
                    }catch (Exception e){
                        Toast.makeText(getActivity(), errorMessage ,Toast.LENGTH_LONG).show();
                    }


                }
            }

            @Override
            public void onFailure(Call<PageData> call, Throwable t) {

            }
        });
    }
}