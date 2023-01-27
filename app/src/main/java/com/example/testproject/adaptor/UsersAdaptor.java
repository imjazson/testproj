package com.example.testproject.adaptor;

//import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.MainActivity;
import com.example.testproject.R;
import com.example.testproject.item_list.Users;

import java.util.List;

public class UsersAdaptor extends RecyclerView.Adapter<UsersAdaptor.ViewHolder> {
    List<Users> usersList;

    public  UsersAdaptor (List<Users> usersList){
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MainActivity.activity).inflate(R.layout.item_layout,parent, false);
        return new ViewHolder(view);
      //  return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdaptor.ViewHolder holder, int position) {
        Users users = usersList.get(position);

        String username, fullname;
        username = users.getUsername();
        fullname = users.getFullname();

        holder.tv_username.setText(username);
        holder.tv_fname.setText(fullname);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder {
        TextView tv_fname, tv_username;
        public ViewHolder( View itemView){
            super(itemView);
            tv_fname = itemView.findViewById(R.id.tv_fname);
            tv_username = itemView.findViewById(R.id.tv_username);
        }
    }

    //sampleeeeffv dgdfh
}
