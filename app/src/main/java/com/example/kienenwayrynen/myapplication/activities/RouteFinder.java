package com.example.kienenwayrynen.myapplication.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.kienenwayrynen.myapplication.R;

import java.lang.reflect.Array;

public class RouteFinder extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_finder);
        Spinner routeStartSpinner = (Spinner) findViewById(R.id.route_start_spinner);
        Spinner routeEndSpinner = (Spinner) findViewById(R.id.route_end_spinner);
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
        ArrayAdapter<CharSequence> routeStartAdapter =
                new ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_1, testArray);
        ArrayAdapter<CharSequence> routeEndAdapter =
                new ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_1, testArray);
        routeStartSpinner.setAdapter(routeStartAdapter);
        routeEndSpinner.setAdapter(routeEndAdapter);

    }


}
