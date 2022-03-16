package katar.example.elgaml.ecommerce.auth.forgetpass;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import katar.example.elgaml.ecommerce.model.ForgetPasswordModel;
import katar.example.elgaml.ecommerce.repostiory.ForgetPasswordRepository;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ForgetPasswordViewModel extends ViewModel {


    public ForgetPasswordRepository forgetPasswordRepository;
    public MutableLiveData<ForgetPasswordModel>  mutableLiveDataForget;

    public void init ()
    {
        if (mutableLiveDataForget!=null ){
            return;
        }

      forgetPasswordRepository =ForgetPasswordRepository.getInstance();
      mutableLiveDataForget = new MutableLiveData<>();
    }


    public void goToConfirmForgot(View view,String phone,int code){
        Intent intent = new Intent(view.getContext(), ConfirmForgotPassword.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("Code",code);
        intent.putExtra("Phone",phone);
        view.getContext().startActivity(intent);
    }

    public LiveData<ForgetPasswordModel> resetPassword(String phone)
    {
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
