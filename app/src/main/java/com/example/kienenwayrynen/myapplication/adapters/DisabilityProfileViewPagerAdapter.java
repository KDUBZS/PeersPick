package com.example.kienenwayrynen.myapplication.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kienenwayrynen.myapplication.fragments.MobilityOptions;
import com.example.kienenwayrynen.myapplication.fragments.PagerFragment;

import java.util.ArrayList;
import java.util.List;

public class DisabilityProfileViewPagerAdapter extends FragmentPagerAdapter {

    private List<PagerFragment> fragments;

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }

    public DisabilityProfileViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new PagerFragment(new MobilityOptions(), "Mobility"));
        fragments.add(new PagerFragment(new MobilityOptions(), "Vision"));
        fragments.add(new PagerFragment(new MobilityOptions(), "Hearing"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}