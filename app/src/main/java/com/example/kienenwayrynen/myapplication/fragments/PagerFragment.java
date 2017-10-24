package com.example.kienenwayrynen.myapplication.fragments;

import android.support.v4.app.Fragment;

public class PagerFragment {

    private Fragment fragment;
    private String title;

    public PagerFragment(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }
}
