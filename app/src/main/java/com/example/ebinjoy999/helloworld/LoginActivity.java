package com.example.ebinjoy999.helloworld;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button buttonLogin;
EditText edittextUserName, edittextPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        edittextUserName = (EditText) findViewById(R.id.editTextUserName);
        edittextPass= (EditText) findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(LoginActivity.this,"Click",Toast.LENGTH_LONG);
                toast.show();

                String user_name = edittextUserName.getText().toString();
                String pass = edittextPass.getText().toString();

                if(user_name.equals("")){
                    edittextUserName.setError("Please enter valid user name.");
                    edittextUserName.requestFocus();
                }else if( pass.equals("")){
                    edittextPass.setError("Please enter valid password.");
                    edittextPass.requestFocus();
                }else if(user_name.equals("ebin") && pass.equals("12345")){
                    //write the code to go screen2

                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("user", edittextUserName.getText().toString());
                    startActivity(intent);

                }else {
                    //here we show alert username password is not correct;
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Error!");
                    builder.setMessage("Username or password is incorrect.");
                    builder.setPositiveButton("OK",null);
                    builder.create().show();
                }
            }
        });

    }
}
