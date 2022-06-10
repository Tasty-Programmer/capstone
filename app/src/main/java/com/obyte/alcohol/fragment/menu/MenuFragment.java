package com.obyte.alcohol.fragment.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.obyte.alcohol.R;
import com.obyte.alcohol.Rest.DrinkData;
import com.obyte.alcohol.Rest.RetrofitHelper;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MenuFragment extends Fragment {

    public MenuFragment(){

    }

    RecyclerView rvLists;
    ArrayList<DrinkData> dataArrayList;
    ViewAdepter viewAdepter;

    private final static String BASE_URL = "https://api.odcloud.kr/api/";
    // private final static String BASE_URL = "http://10.0.0.2:8080/";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_menu,container,false);
        init(viewGroup);

        setLayoutManager();

        serverConnect();

        return viewGroup;
    }


    public void init(ViewGroup viewGroup) {
        rvLists = viewGroup.findViewById(R.id.rvLists);
        dataArrayList = new ArrayList<>();
        viewAdepter = new ViewAdepter(dataArrayList, getContext());
    }

    private void setLayoutManager(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvLists.setLayoutManager(linearLayoutManager);
        rvLists.setAdapter(viewAdepter);
    }

    private void serverConnect(){
        Observable.just(BASE_URL)
                .map(RetrofitHelper::connect)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data ->  {
                    dataArrayList.addAll(data);
                    viewAdepter.notifyItemRangeInserted(viewAdepter.getItemCount(), data.size());
                }, throwable -> {
                    Toast.makeText(getContext(), throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                });
    }
}