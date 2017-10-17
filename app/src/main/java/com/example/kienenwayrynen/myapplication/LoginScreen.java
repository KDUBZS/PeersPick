package com.example.kienenwayrynen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

    }

    @Override
    public void onClick(View view) {
        Intent next = new Intent(this, RegistrationScreen.class);
        startActivity(next);
    }
}
