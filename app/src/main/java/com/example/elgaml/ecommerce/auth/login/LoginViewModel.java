package com.example.elgaml.ecommerce.auth.login;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.home.Home;
import com.example.elgaml.ecommerce.repostiory.LoginRepository;
import com.example.elgaml.ecommerce.model.User;

public class LoginViewModel extends ViewModel {
    LoginRepository signInRepository;
    public MutableLiveData<User> userMutableLiveData;


    public void init(){
        if (userMutableLiveData !=null){
            return;
        }
        signInRepository= LoginRepository.getInstance() ;
    }

    public LiveData<User> signIn(String name, String password){
        return signInRepository.SignIn(name,password);
    }


    public void goToHome(View view){
        Intent intent = new Intent(view.getContext(), Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        view .getContext().startActivity(intent);
    }

    public SharedPreferences getsSharedPreferences(String MY_PREFS_NAME, Context context){
        SharedPreferences  pref =context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return pref;
    }

    public SharedPreferences.Editor editorSaveUserData(String MY_PREFS_NAME, Context context, String key, String value){

        SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putString(key, value);
        editor.apply();
        return editor;

    }

}
