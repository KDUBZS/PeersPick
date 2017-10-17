package com.example.kienenwayrynen.myapplication;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by kienenwayrynen on 10/5/17.
 */

public class RegistrationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Button registerButton = (Button) findViewById(R.id.submit_registration_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText password = (TextInputEditText)findViewById(R.id.password);
                TextInputEditText confirmPassword = (TextInputEditText)findViewById(R.id.confirm_password);
                if(password.getText().toString().equals(confirmPassword.getText().toString())){
                    Log.d("click","blahloggedin");
                }else{
                    Toast.makeText(RegistrationScreen.this, "passwords do not match", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
