package com.project.mvvm;

import android.content.Context;
import android.content.Intent;
import android.service.autofill.UserData;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Room;

import com.project.mvvm.model.User;

public class ViewModel extends BaseObservable {

    public Model model;
    Context context;

    String sucess = "Login successful";
    String fail = "Login Unsuccessful";
    UserDao db;
    UserDataBase dataBase;
    private UserDao userDao;

    private String toastMessage = null;

    public ViewModel(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    public ViewModel(ViewModel viewModel, MainActivity instance) {
        this.context = instance;
       model = new Model("", "");

    }

    public ViewModel(ViewModel viewModel, UserDataBase dataBase, UserDao userDao) {
        this.dataBase = dataBase;
        this.userDao = userDao;
        model = new Model("", "");
    }


    //  db = dataBase.getUser();


@Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    @Bindable
    public String getModelEmail() {
        return model.getEmail();
    }

    public void setModelEmail(String userEmail) {
        model.setEmail(userEmail);
        notifyPropertyChanged(BR.modelEmail);
    }

    //getter setter for password
    @Bindable
    public String getPassword() {
        return model.password;
    }

    public void setPassword(String pwd) {
        model.setPassword(pwd);
        notifyPropertyChanged(BR.password);
    }

    //viewModel constructor

    public ViewModel() {
        model = new Model("", "");
    }


    //actions on login button

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    public  void  onLoginclick(){
        if (isValid()) {
           setToastMessage("Login Successful");
        }else{
            setToastMessage("Login Unsuccessful");
        }
    }

    public Context getContext() {
        return context;
    }



    public void onRegisterclick() {
        if (isValid()) {
           // Toast.makeText(this, sucess, Toast.LENGTH_SHORT).show();
            try {
                /*db = dataBase.getUser();
                Model user = new Model(getModelEmail(), getPassword());
                userDao.insert(user);
                Log.d("User Data",user.toString());*/
                //startNewActivity(RegisterActivity.class);


            }catch (Exception e){
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
          /*  if (user != null) {
                Intent i = new Intent(this, HomeActivity.class);
                i.putExtra("User", user);
                startActivity(i);
                finish();
            }
            else{
                //Toast.makeText(context, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
            }*/
            setToastMessage(sucess);
        } else {
            setToastMessage(fail);
        }
    }


    public boolean isValid() {
        if (!(getModelEmail().isEmpty() || (Patterns.EMAIL_ADDRESS.matcher(getModelEmail()).matches()) || getModelEmail().length() > 5)) {
            return false;
        }else {
            return true;
        }
    }

    public String getSucess() {
        return sucess;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }

    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }

}

