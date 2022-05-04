package com.obyte.alcohol.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
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
    ArrayList<DrinkData> DataArrayList;
    ViewAdepter viewAdepter;


    final static String BASEURL = "https://api.odcloud.kr/api/";
    final static String SERVICEKEY = "PiupwYl4E3qXUITudPuqSalNK8/yzD8jOUgFtMIZJkEB2CPsZaDBfae+UAU9MoNKBJLvaUxIlq5jY2WwzDmEeg==";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_menu,container,false);
        init(viewGroup);

        DataArrayList = new ArrayList<>();
        viewAdepter = new ViewAdepter(DataArrayList, getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), GridLayoutManager.DEFAULT_SPAN_COUNT);
        rvLists.setLayoutManager(gridLayoutManager);
        rvLists.setAdapter(viewAdepter);

        serverConnet();

        return viewGroup;
    }

    public void init(ViewGroup viewGroup) {
        rvLists = viewGroup.findViewById(R.id.rvLists);
    }

    public void serverConnet(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServerService serverService = retrofit.create(ServerService.class);
        Call<PageData> call = serverService.getData(1, 100, SERVICEKEY);

        call.enqueue(new Callback<PageData>() {
            @Override
            public void onResponse(Call<PageData> call, Response<PageData> response) {
                if (response.isSuccessful()) {
                         DataArrayList.add = response.body().getData();
                         viewAdepter.notifyDataSetChanged();

                }else{
                    String errorMessage = null;
                    try{
                        errorMessage =response.errorBody().string();
                    }catch (Exception e){

                    }

                    Toast.makeText(getActivity(), errorMessage ,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PageData> call, Throwable t) {

            }
        });
    }
}