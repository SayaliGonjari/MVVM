package com.project.mvvm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Model implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;
    String email, password;

    public Model(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }


}

