package com.example.kienenwayrynen.myapplication.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kienenwayrynen.myapplication.R;
import com.example.kienenwayrynen.myapplication.adapters.DisabilityProfileViewPagerAdapter;

public class DisabilityProfile extends AppCompatActivity {

    TextView numStairs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disability_profile_activity);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        DisabilityProfileViewPagerAdapter adapter = new DisabilityProfileViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
    }


    public void walk_uneven_onCheckboxClicked(View view) {
    }

    public void own_placard_onCheckboxClicked(View view) {
    }
}
