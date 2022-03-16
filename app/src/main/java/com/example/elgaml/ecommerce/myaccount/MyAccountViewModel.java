package com.example.elgaml.ecommerce.myaccount;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.auth.login.LoginActivity;
import com.example.elgaml.ecommerce.model.MyAccountModel.UserResponse;
import com.example.elgaml.ecommerce.repostiory.MyAccountRepository;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class MyAccountViewModel extends ViewModel {

    private MyAccountRepository myAccountRepository;
    void init(){
        myAccountRepository= new MyAccountRepository();
    }

    public LiveData<UserResponse> getProfile(String api_token){
        MutableLiveData<UserResponse> mutableLiveData = new MutableLiveData<>();
        myAccountRepository.getProfile(api_token).subscribe(new SingleObserver<UserResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(UserResponse user)
            {
               mutableLiveData.setValue(user);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Errorr", ((HttpException)e).code()+"");
            }
        });
        return mutableLiveData;
    }

    public void goToLogin(View view){
        Intent intent = new Intent(view.getContext(),LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }

}
