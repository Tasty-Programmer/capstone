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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void init(ViewGroup viewGroup) {
        fragment1 = viewGroup.findViewById(R.id.home_fragment1);
    }




}