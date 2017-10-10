package com.example.kienenwayrynen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username_string);
        TextView pass = (TextView) findViewById(R.id.pass_string);

        username.setOnClickListener(this);
        pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent next = new Intent(this, NextActivity.class);
        startActivity(next);
    }
}
