package com.project.mvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Model.class},version = 1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {


    public static MainActivity mInstance = null;
    static Context mContext;

    public abstract UserDao getUser();

    public static MainActivity getInstance( Context context){
        if (mInstance ==null){
            mInstance = new MainActivity();
        }
        mContext = context;
        return mInstance;
    }
}