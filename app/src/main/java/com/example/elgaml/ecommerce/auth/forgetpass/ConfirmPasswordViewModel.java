package com.example.elgaml.ecommerce.auth.forgetpass;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.elgaml.ecommerce.auth.login.LoginActivity;
import com.example.elgaml.ecommerce.model.ForgetPasswordModel;
import com.example.elgaml.ecommerce.repostiory.ForgetPasswordRepository;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ConfirmPasswordViewModel  {

    public ForgetPasswordRepository forgetPasswordRepository;

    void init(){
        forgetPasswordRepository = new ForgetPasswordRepository();
    }

    public void goToNewPassword(View view,String phone, int code){
        Intent intent = new Intent(view.getContext(), NewPassword.class);
        intent.putExtra("Code",code);
        intent.putExtra("Phone",phone);
        view.getContext().startActivity(intent);
    }

    public void goToLogin(View view){
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        view.getContext().startActivity(intent);
    }
    public LiveData<ForgetPasswordModel> resetPassword(String phone)
    {
        MutableLiveData<ForgetPasswordModel> mutableLiveDataForget = new MutableLiveData<>();
        forgetPasswordRepository.send_reset(phone)
                .subscribe(new SingleObserver<ForgetPasswordModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ForgetPasswordModel forgetPasswordModel) {
                        mutableLiveDataForget.setValue(forgetPasswordModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("forget password error",e.getMessage());
                        mutableLiveDataForget.setValue(null);
                    }
                });

        return mutableLiveDataForget;
    }
}
