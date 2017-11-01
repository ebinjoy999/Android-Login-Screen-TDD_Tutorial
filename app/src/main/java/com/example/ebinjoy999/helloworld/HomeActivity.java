package com.example.ebinjoy999.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textViewUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewUserName = (TextView) findViewById(R.id.textViewUserName);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("user");
        textViewUserName.setText("Hello "+userName);

    }
}
