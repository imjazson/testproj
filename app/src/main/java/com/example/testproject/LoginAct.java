package com.example.testproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.model.UserModel;
import com.google.android.material.snackbar.Snackbar;

public class LoginAct extends AppCompatActivity {

    EditText username, pword ;
    Button btn_login;
    UserModel usermodel;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.)
        getSupportActionBar().setTitle("LOG IN");
        setContentView(R.layout.layout_loginform);


        btn_login = findViewById(R.id.btn_login);

        username = findViewById(R.id.username);
        pword = findViewById(R.id.pword);

        usermodel = new UserModel();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usermodel.Authentication(username.getText().toString(), pword.getText().toString())){
                    Intent intent = new Intent(LoginAct.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Snackbar.make(view, "Login Failed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

}
