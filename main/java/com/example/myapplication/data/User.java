package com.example.myapplication.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public  int user_id;
    @ColumnInfo
    public String name;
    @ColumnInfo
    public String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
