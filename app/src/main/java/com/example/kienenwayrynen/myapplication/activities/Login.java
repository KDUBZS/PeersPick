package com.example.kienenwayrynen.myapplication.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.kienenwayrynen.myapplication.R;

import org.json.JSONObject;

public class Login extends AppCompatActivity implements View.OnClickListener {


    private String USERNAME_KEY = "username";
    private String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(this);

        Button loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("json", profileAsJson());
                startActivity(new Intent(Login.this,DisabilityProfile.class));
            }

        });
        setTitle("Login");
    }

    private String profileAsJson() {
        JSONObject postData = new JSONObject();
        TextInputEditText username = (TextInputEditText) findViewById(R.id.username_edit_text);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.password_edit_text);

        try {
            postData.put(USERNAME_KEY, username.getText());
            postData.put(PASSWORD_KEY, password.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postData.toString();
    }

    @Override
    public void onClick(View view) {
        Intent next;
        if (view.getId() == R.id.register_button) {
            next = new Intent(this, Registration.class);
        } else {
            next = new Intent(this, DisabilityProfile.class);
        }
        startActivity(next);
    }
}
