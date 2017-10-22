package com.example.android.gudhangapp;

/**
 * Created by Rio on 10/20/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private TextView goBackLogin;
    private EditText fullName;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirm;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullName = (EditText)findViewById(R.id.name);
        username = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        confirm = (EditText)findViewById(R.id.confirm);

        signupBtn = (Button)findViewById(R.id.SignupButton);

        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!validate()) {

                } else {
                    launchProfile();
                }
            }
        });

        goBackLogin = (TextView)findViewById(R.id.openLoginButton);

        goBackLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String fullText = fullName.getText().toString();
        String userText = username.getText().toString();
        String mailText = email.getText().toString();
        String passText = password.getText().toString();
        String confirmText = confirm.getText().toString();

        if(fullText.isEmpty()) {
            fullName.setError("Fill your full name");
            valid = false;
        } else {
            fullName.setError(null);
        }

        if(userText.isEmpty()) {
            username.setError("Fill your username");
            valid = false;
        } else {
            username.setError(null);
        }

        if(mailText.isEmpty()) {
            email.setError("Fill your email");
            valid = false;
        } else {
            email.setError(null);
        }

        if(passText.isEmpty()||passText.length()<4) {
            password.setError("Password must have minimum 4 characters");
            valid = false;
        } else {
            password.setError(null);
        }

        if(confirmText.isEmpty()||!confirmText.equals(passText)) {
            confirm.setError("Password not matched");
            valid = false;
        } else {
            confirm.setError(null);
        }

        return valid;
    }

    public void launchProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("name", fullName.getText().toString());
        intent.putExtra("username", username.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("password", password.getText().toString());
        intent.putExtra("confirm", confirm.getText().toString());
        startActivity(intent);
    }

}
