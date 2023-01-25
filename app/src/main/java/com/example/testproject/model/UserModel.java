package com.example.testproject.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.testproject.core.SqlLiteDB;
import com.example.testproject.item_list.Users;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    List<Users> usersList = new ArrayList<>();

    public UserModel(){

    }

    public boolean add_user(String full_name, String username, String password){
        boolean result = false;

        SQLiteDatabase db = SqlLiteDB.getDB();
        String query = "INSERT INTO tbl_user(full_name, username, password)" +
                "VALUES('"+ full_name +"', '" + username +"','" +password +"')";
        try{
            db.execSQL(query);
            result = true;
        }catch(Exception e){}

        return result;
    }

    public String show_users(){
        String users = "";
        SQLiteDatabase db = SqlLiteDB.getDB();

        String query = "SELECT * FROM tbl_user ";
        try{
            Cursor cursor = db.rawQuery( query, null);
            if (cursor.moveToFirst()){
                do {
                    users += cursor.getString( 1) + " " + cursor.getString( 2) + "\n";

                }while (cursor.moveToNext());
            }
            else{

            }

        }catch (Exception e){}
        db.close();
        return users;
    }

    public  boolean Authentication( String username, String password){
        SQLiteDatabase db = SqlLiteDB.getDB();
        boolean authenticated = false;

        String query = "SELECT full_name FROM tbl_user where username ='" + username +
                    "' and password = '"+ password +"'";
        try{
            Cursor cursor = db.rawQuery( query, null);
            if (cursor.moveToFirst()){
                    if (cursor.getString( 0 ) == null)
                        return false;
                    authenticated = true;
            }
            else{
                return false;
            }

        }catch (Exception e){}
        db.close();
        return authenticated;


    }

    public List<Users> getUsers(){
        SQLiteDatabase db = SqlLiteDB.getDB();
        String sql = "SELECT full_name, username from tbl_user ";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                String fullname = cursor.getString(0);
                String username = cursor.getString(1);

                usersList.add(new Users(fullname, username));


            } while (cursor.moveToNext());
        }
        db.close();
        return usersList;
    }

}
