package com.project.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Model WHERE email=:email and password=:password")
    Model getUser(String email,String password);
    @Insert
    void insert(Model userData);

    @Query("SELECT * FROM Model")
    public Model[] loadAllUsers();

}
