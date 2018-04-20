package com.example.kienenwayrynen.myapplication.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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

import org.json.JSONException;
import org.json.JSONObject;

public class DisabilityProfile extends AppCompatActivity {

    TextView numStairs;
    private String USERNAME_KEY = "username";
    private String EMAILADDRESS_KEY = "emailaddress";
    private String STAIRLIMIT_KEY = "stair_limit";
    private String RAMPLENGTH_KEY = "ramp_length";
    private String WALKUNEVEN_KEY = "walk_uneven";
    private String OWNPLACARD_KEY = "own_placard";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disability_profile_activity);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        DisabilityProfileViewPagerAdapter adapter = new DisabilityProfileViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tabs.setupWithViewPager(viewpager);
        Button tempButton = (Button) findViewById(R.id.temp_button);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(DisabilityProfile.this, RouteFinder.class);
                startActivity(next);
                System.out.println(profileAsJson());
            }

        });
    }

    private String profileAsJson() {
        JSONObject postData = new JSONObject();
        EditText stairs = (EditText) findViewById(R.id.stairs_edit_text);
        EditText ramp_length = (EditText) findViewById(R.id.ramp_length_edit_text);
        CheckBox walk_uneven = (CheckBox) findViewById(R.id.walk_uneven_surfaces_checkbox);
        CheckBox own_placard = (CheckBox) findViewById(R.id.own_ada_placard_checkbox);


        try {
            postData.put(USERNAME_KEY, "test");
            postData.put(EMAILADDRESS_KEY, "test@test.com");
            postData.put(STAIRLIMIT_KEY, stairs.getText().toString());
            postData.put(RAMPLENGTH_KEY, ramp_length.getText().toString());
            postData.put(WALKUNEVEN_KEY, String.valueOf(walk_uneven.isChecked()));
            postData.put(OWNPLACARD_KEY, String.valueOf(own_placard.isChecked()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postData.toString();
    }
}
