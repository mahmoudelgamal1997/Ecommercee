package com.example.elgaml.ecommerce.repostiory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.elgaml.ecommerce.model.SignInModel;
import com.example.elgaml.ecommerce.model.User;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository
{
    public static LoginRepository signInRepository;
    private APIinterface apIinterface;

    public static LoginRepository getInstance(){
        if (signInRepository == null){
            signInRepository = new LoginRepository();
        }
        return signInRepository;
    }

    public LoginRepository(){
        apIinterface= RetrofitRequest.cteateService(APIinterface.class);
    }
    public MutableLiveData<User> SignIn(String name, String password){
        final MutableLiveData<User> newsData = new MutableLiveData<>();
        apIinterface.signin(name, password).enqueue(new Callback<SignInModel>() {
            @Override
            public void onResponse(Call<SignInModel> call,Response<SignInModel> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body().getUser());
                }else{
                    newsData.setValue(null);
                }}
            @Override
            public void onFailure(Call<SignInModel> call, Throwable t) {
                Log.e("errorSignIn",t.getMessage());
            }
        });
        return newsData;
    }

/*
    public LiveData<User> signIn(String name,String password){


        apIinterface.signin(name,password).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                _user.postValue(response.body());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

     return userLiveData;

  */
     }
