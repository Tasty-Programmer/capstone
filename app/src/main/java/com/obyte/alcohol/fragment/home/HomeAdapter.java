package com.obyte.alcohol.fragment.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.obyte.alcohol.fragment.home.fragment.game;
import com.obyte.alcohol.fragment.home.fragment.mbti;
import com.obyte.alcohol.fragment.home.fragment.quiz;

public class HomeAdapter extends FragmentStateAdapter {

    public int mCount;
    public HomeAdapter(HomeFragment fa, int count) {
        super(fa);
        mCount = count;
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index==0) return new game();
        else if(index==1) return new mbti();
        else return new quiz();
    }
    @Override
    public int getItemCount() {
        return 2000;
    }
    public int getRealPosition(int position) { return position % mCount; }
}