package com.example.elgaml.ecommerce.auth;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.example.elgaml.ecommerce.Home.Home;
import com.example.elgaml.ecommerce.model.ChangePasswordModel;
import com.example.elgaml.ecommerce.repostiory.NewPasswordRepository;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class NewPasswordViewModel {

    public NewPasswordRepository newPasswordRepository;
    public MutableLiveData<ChangePasswordModel> mutableLiveData;
    CompositeDisposable compositeDisposable =new CompositeDisposable();

    public void init () {
        if (mutableLiveData!=null ){
            return;
        }

        newPasswordRepository = NewPasswordRepository.getInstance();
        mutableLiveData = new MutableLiveData<>();
    }

    public void sendnewPass(String phone, String code, String newpass) {

        newPasswordRepository.sendnewPass(phone,code,newpass)
                .subscribe(new SingleObserver<ChangePasswordModel>() {
            @Override
            public void onSubscribe(Disposable d) {


            }
            @Override
            public void onSuccess(ChangePasswordModel changePasswordModel) {
                mutableLiveData.setValue(changePasswordModel);
            }
            @Override
            public void onError(Throwable e) {
                mutableLiveData.setValue(null);
            }

                }
        ); }

    public void goToHome(View view){
        Intent intent = new Intent(view.getContext(), Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        view.getContext().startActivity(intent);
    }


}
