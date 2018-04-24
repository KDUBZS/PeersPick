package com.example.kienenwayrynen.myapplication.activities;

import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.kienenwayrynen.myapplication.R;
import com.example.kienenwayrynen.myapplication.model.Graph;
import com.example.kienenwayrynen.myapplication.view.PathImageView;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;

public class RouteFinder extends NavigableActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContent(R.layout.route_finder);
        String[] testArray = {"Annex",
                "Clark College Building (VCCW)",
                "Classroom Building (VCLS)",
                "Dengerink Administration Building (VDEN)\n" + "Cafeteria",
                "Engineering & Computer\n" + "Science Building (VECS)",
                "Facilities Operations Building (VFO)",
                "Firstenburg Student Commons (VFSC)",
                "Library Building (VLIB)",
                "McClaskey Building (VMCB)\n" + "Child Development Program",
                "Multimedia Classroom Building (VMMC)",
                "Physical Plant Building (VPP)\n" + "Parking Services",
                "Science & Engineering Building (VSCI)",
                "Student Services Center (VSSC)\n" + "Admissions, Bookstore,\n" +
                "Financial Aid, Visitor’s Center",
                "Undergraduate Building (VUB)"};

        WebView webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new Callback());
        webView.getSettings().setJavaScriptEnabled(true);
        setTitle("Path Finder");
        int stairs = PreferenceManager.getDefaultSharedPreferences(this).getInt("stairs", 999);
        webView.loadUrl("http://ec2-54-148-84-77.us-west-2.compute.amazonaws.com/peerspick/view_path?stairs=" + stairs);

    }

    private class Callback extends WebViewClient{  //HERE IS THE MAIN CHANGE.

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }

    }


}
