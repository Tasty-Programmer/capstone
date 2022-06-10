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
import com.obyte.alcohol.Rest.RetrofitHelper;
import com.obyte.alcohol.Rest.ServerService;
import com.obyte.alcohol.ViewAdepter;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
                    //Toast.makeText(getContext(), "서버 연결에 실패했습니다.", Toast.LENGTH_LONG).show();
                });
    }
}