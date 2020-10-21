package com.example.elgaml.ecommerce.repostiory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.elgaml.ecommerce.model.SignUpErrorModel;
import com.example.elgaml.ecommerce.model.SignUpModel;
import com.example.elgaml.ecommerce.model.User;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository  {

    public static SignUpRepository signUpRepository;
    public MutableLiveData<SignUpErrorModel> error_signup = new MutableLiveData<>();

    private APIinterface apIinterface;

    public static SignUpRepository getInstance(){
         if (signUpRepository==null){
             signUpRepository=new SignUpRepository();
         }
         return signUpRepository;
    }

    public SignUpRepository (){
        apIinterface= RetrofitRequest.cteateService(APIinterface.class);
    }


    public MutableLiveData<User> SignUp(final String name, String email, String phone, String password){
        final MutableLiveData<User> userData = new MutableLiveData<>();

        apIinterface.signup(name,email,phone, password).enqueue(new Callback<SignUpModel>() {
            @Override
            public void onResponse(Call<SignUpModel> call,
                                   Response<SignUpModel> response) {
                if (response.isSuccessful()){
                    userData.setValue(response.body().getUser());
                    Log.e("SignUP",response.body().getUser().getEmail().toString());
                    error_signup.setValue(null);
                } else {

                    SignUpErrorModel signUpErrorModel= null;
                    try {
                        signUpErrorModel = new Gson().fromJson(response.errorBody().string(), SignUpErrorModel.class);
                        Log.e("error message", signUpErrorModel.getErrors().get(0).getMessage());
                      error_signup.setValue(signUpErrorModel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {
                //  newsData.setValue();

                Log.e("errorSignup",t.getMessage());
            }
        });

        return userData;
    }



}
