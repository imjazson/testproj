package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
//import android.widget.TextView;

import com.example.testproject.adaptor.UsersAdaptor;
import com.example.testproject.item_list.Users;
import com.example.testproject.model.UserModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //TextView db_users ;
    RecyclerView rv_users;
    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("HOME");
        setContentView(R.layout.activity_main);

       // UserModel  model = new UserModel();
       // model.add_user("user1", "user1", "123");
        activity = this;

        UserModel model = new UserModel();
        List<Users> userlist = model.getUsers();
        UsersAdaptor adaptor = new UsersAdaptor(userlist);

        rv_users = findViewById(R.id.rv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rv_users.setLayoutManager(linearLayoutManager);
        rv_users.setAdapter(adaptor);

       // db_users = findViewById(R.id.db_users);
       // db_users.setText(model.show_users());

    }
}