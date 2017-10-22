package com.example.android.gudhangapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private TextView fullname;
    private TextView username;
    private TextView email;
    private TextView password;
    private TextView confirm;
    private Button logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullname = (TextView)findViewById(R.id.fullname);
        username = (TextView)findViewById(R.id.username);
        email = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.password);
        confirm = (TextView)findViewById(R.id.confirm);
        logoutBtn = (Button)findViewById(R.id.LogoutButton);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String user = i.getStringExtra("username");
        String mail = i.getStringExtra("email");
        String pass = i.getStringExtra("password");
        String conpass = i.getStringExtra("confirm");
        Log.e("Profile Screen", name + "." + password);

        fullname.setText(name);
        username.setText(user);
        email.setText(mail);
        password.setText(pass);
        confirm.setText(conpass);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }

        });
    }
}
