package com.example.kienenwayrynen.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kienenwayrynen.myapplication.R;

public class MobilityOptions extends Fragment {

    private TextInputEditText stairs;

    public int getStairs() {
        try {
            return Integer.parseInt(stairs.getText().toString());
        } catch (Exception e) {
            return 9999;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mobility_profile, null, false);

        stairs = (TextInputEditText) view.findViewById(R.id.stairs);

        return view;
    }
}
