package com.obyte.alcohol.fragment.home.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.obyte.alcohol.R;



public class game extends Fragment {
    private ImageView fragment1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_home_fram_game, container, false);

        init(rootView);


        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.search.naver.com/search.naver?query=%EB%84%A4%EC%9D%B4%EB%B2%84+%EA%B0%84%EB%8B%A8%EA%B2%8C%EC%9E%84&where=m&sm=mtp_sly.hst&acr=1"));
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void init(ViewGroup viewGroup) {
        fragment1 = viewGroup.findViewById(R.id.home_fragment1);
    }




}