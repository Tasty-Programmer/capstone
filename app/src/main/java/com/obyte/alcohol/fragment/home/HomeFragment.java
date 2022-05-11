package com.obyte.alcohol.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obyte.alcohol.R;

import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;
    private CircleIndicator3 mIndicator;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIn1stanceState) {
        super.onCreate(savedIn1stanceState);
        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);
        init(viewGroup);



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
    }


}