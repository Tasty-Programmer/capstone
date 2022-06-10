package com.obyte.alcohol.fragment.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.obyte.alcohol.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;
    private CircleIndicator3 mIndicator;
    private TextView LinkedText1,LinkedText2;
    private ImageView testAlcohol;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIn1stanceState) {
        super.onCreate(savedIn1stanceState);
        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);
        init(viewGroup);

        viewPagerSetUp();

        setEventListener();

        return viewGroup;
    }

    public void init(ViewGroup viewGroup) {
        //ViewPager2
        mPager = viewGroup.findViewById(R.id.Home_ViewPager2);
        //Adapter
        pagerAdapter = new HomeAdapter(this, num_page);
        mPager.setAdapter(pagerAdapter);
        //Indicator
        mIndicator = viewGroup.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.createIndicators(num_page,0);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        LinkedText1 = viewGroup.findViewById(R.id.LinkedText1);
        LinkedText2 = viewGroup.findViewById(R.id.LinkedText2);
        testAlcohol = viewGroup.findViewById(R.id.Home_MainHomePage);

    }

    private void viewPagerSetUp(){
        mPager.setSaveEnabled(false);
        mPager.setCurrentItem(1000);    //Start Point
        mPager.setOffscreenPageLimit(3);    //Fragments

        mPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                if(positionOffsetPixels == 0){
                    mPager.setCurrentItem(position);
                }
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mIndicator.animatePageSelected(position%num_page);
            }
        });

        autoSlidingInterval();
    }

    private void autoSlidingInterval(){
        Observable.interval(5L, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.from(Looper.getMainLooper()))
                .subscribe(num -> mPager.setCurrentItem(mPager.getCurrentItem() + 1, true));
    }

    private void setEventListener(){
        testAlcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thesool.com/aiSommelier/main.html"));
                startActivity(intent);
            }
        });

        LinkedText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thesool.com/front/home/M000000000/index.do"));
                startActivity(intent);

            }
        });

        LinkedText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.daelim.ac.kr/index.do"));
                startActivity(intent);

            }
        });
    }


}