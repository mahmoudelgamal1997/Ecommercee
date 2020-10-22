package com.example.elgaml.ecommerce.auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.Home.Home;
import com.example.elgaml.ecommerce.model.SignUpErrorModel;
import com.example.elgaml.ecommerce.model.User;
import com.example.elgaml.ecommerce.repostiory.SignUpRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.MODE_PRIVATE;

public class SignUpViewModel extends ViewModel {

    SignUpRepository signUpRepository;
    MutableLiveData<SignUpErrorModel> signuperror;

    public void init(SignUpRepository signUpRepository){
        if (signuperror !=null){
            return;
        }
        signuperror=new MutableLiveData<>();
        this.signUpRepository= signUpRepository;

    }


    public LiveData<User> signUp(String name,String email,String phone, String password){
     return  signUpRepository.SignUp(name,email,phone,password);
    }

    public LiveData<SignUpErrorModel> signUpErrorModel(){
     signuperror=  signUpRepository.error_signup;
    return signuperror;
    }

    public SharedPreferences getsSharedPreferences(String MY_PREFS_NAME, Context context){
      SharedPreferences  pref =context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
      return pref;
    }

    public SharedPreferences.Editor editorSaveUser(String MY_PREFS_NAME, Context context, String key, boolean value){

     SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putBoolean(key, value); // Storing boolean
        editor.apply();
        return editor;

    }

    public SharedPreferences.Editor editorSaveUserID(String MY_PREFS_NAME, Context context, String key, String value){

        SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putString(key, value); // Storing boolean
        editor.apply();
        return editor;

    }
    public SharedPreferences.Editor editorSaveUserName(String MY_PREFS_NAME, Context context, String key, String value){

        SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putString(key, value); // Storing boolean
        editor.apply();
        return editor;

    }
 public SharedPreferences.Editor editorSaveUserEmail(String MY_PREFS_NAME, Context context, String key, String value){

        SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putString(key, value); // Storing boolean
        editor.apply();
        return editor;

    }

    public SharedPreferences.Editor editorSaveUserImage(String MY_PREFS_NAME, Context context, String key, String value){

        SharedPreferences.Editor editor=getsSharedPreferences(MY_PREFS_NAME, context).edit();
        editor.putString(key, value); // Storing boolean
        editor.apply();
        return editor;

    }

    public void goToHome(View view){
        Intent intent = new Intent(view.getContext(), Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        view .getContext().startActivity(intent);
    }

}
