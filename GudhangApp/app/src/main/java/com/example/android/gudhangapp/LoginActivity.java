package com.example.android.gudhangapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.string.no;

public class LoginActivity extends AppCompatActivity {

    private TextView launchSignup;
    private Button loginBtn;
    private EditText inputNama;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputNama = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.LoginButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(!validate()) {

                } else {
                    launchProfileActivity();
                }

            }
        });

        launchSignup = (TextView) findViewById(R.id.openSignupButton);

        launchSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSignup();
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String usertext = inputNama.getText().toString();
        String passtext = password.getText().toString();

        if(usertext.isEmpty()) {
            inputNama.setError("Please fill username");
            valid = false;
        } else {
            inputNama.setError(null);
        }

        if(passtext.isEmpty()) {
            password.setError("Password not entered");
            valid = false;
        } else {
            password.setError(null);
        }

        return valid;
    }

    private void launchProfileActivity() {
        Intent launchProfile = new Intent(this, ProfileActivity.class);
        launchProfile.putExtra("name", inputNama.getText().toString());
        launchProfile.putExtra("password", password.getText().toString());
        Log.e("n",inputNama.getText()+"."+ password.getText());
        startActivity(launchProfile);
    }

    public void launchSignup() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

}
