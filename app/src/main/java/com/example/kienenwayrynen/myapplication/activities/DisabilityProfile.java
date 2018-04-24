package com.example.kienenwayrynen.myapplication.activities;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kienenwayrynen.myapplication.R;
import com.example.kienenwayrynen.myapplication.adapters.DisabilityProfileViewPagerAdapter;
import com.example.kienenwayrynen.myapplication.fragments.MobilityOptions;

public class DisabilityProfile extends NavigableActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContent(R.layout.disability_profile_activity);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        final MobilityOptions option = new MobilityOptions();
        DisabilityProfileViewPagerAdapter adapter = new DisabilityProfileViewPagerAdapter(getSupportFragmentManager(), option);
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
        Button tempButton = (Button) findViewById(R.id.temp_button);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(DisabilityProfile.this, RouteFinder.class);
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(DisabilityProfile.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("stairs", option.getStairs());
                editor.commit();
                startActivity(next);
            }

        });
        setTitle("Disability Profile");
    }

}
