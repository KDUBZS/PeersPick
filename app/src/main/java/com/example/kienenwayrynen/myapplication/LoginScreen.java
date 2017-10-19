package com.example.kienenwayrynen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        Button loginBUtton = (Button) findViewById(R.id.button_login);
        loginBUtton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent next;
        if (view.getId() == R.id.register_button) {
            next = new Intent(this, RegistrationScreen.class);
        } else {
            next = new Intent(this, DisabilityProfile.class);
        }
        startActivity(next);
    }
}
