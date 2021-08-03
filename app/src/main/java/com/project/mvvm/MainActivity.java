package com.project.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    UserDao db;
    UserDataBase dataBase;
    UserDao  userDao ;
    public static MainActivity mInstance = null;
    static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        dataBase = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUser();

        db = dataBase.getUser();
        userDao.loadAllUsers();


        UserDataBase.getInstance(MainActivity.this);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        activityMainBinding.setViewModel(new ViewModel(new ViewModel(),dataBase,userDao));
        activityMainBinding.executePendingBindings();


    }

    @BindingAdapter({"toastMsg"})
    public static void runMe(View view, String msg) {
        if (msg != null) {
            Toast.makeText(view.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static MainActivity getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MainActivity();
        }
        mContext = context;
        return mInstance;
    }


}