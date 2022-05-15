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

public class naverdictionary extends Fragment {
    private ImageView fragment3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_home_fram_naverdictionary, container, false);

        init(rootView);

        fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.daum.net"));
                startActivity(intent);
            }
        });



        return rootView;
    }

    public void init(ViewGroup viewGroup) {
        fragment3 = viewGroup.findViewById(R.id.home_fragment3);
    }
}