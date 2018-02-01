package com.example.kienenwayrynen.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kienenwayrynen.myapplication.R;

import org.json.JSONObject;


public class Registration extends AppCompatActivity {

    private String USERNAME_KEY = "username";
    private String PASSWORD_KEY = "password";
    private String EMAILADDRESS_KEY = "emailaddress";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Button registerButton = (Button) findViewById(R.id.submit_registration_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText password = (TextInputEditText)findViewById(R.id.password_edit_text);
                TextInputEditText confirmPassword = (TextInputEditText)findViewById(R.id.confPass_edit_text);
                if(password.getText().toString().equals(confirmPassword.getText().toString())){
                    Log.d("json", profileAsJson());
                    startActivity(new Intent(Registration.this,DisabilityProfile.class));

                }else{
                    Toast.makeText(Registration.this, "passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private String profileAsJson() {
        JSONObject postData = new JSONObject();
        TextInputEditText username = (TextInputEditText) findViewById(R.id.username_edit_text);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.password_edit_text);
        TextInputEditText emailaddress = (TextInputEditText) findViewById(R.id.email_edit_text);

        try {
            postData.put(USERNAME_KEY, username.getText());
            postData.put(PASSWORD_KEY, password.getText());
            postData.put(EMAILADDRESS_KEY, emailaddress.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postData.toString();
    }

}
