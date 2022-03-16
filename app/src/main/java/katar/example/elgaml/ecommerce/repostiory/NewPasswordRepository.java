package katar.example.elgaml.ecommerce.repostiory;

import katar.example.elgaml.ecommerce.model.ChangePasswordModel;
import katar.example.elgaml.ecommerce.retrofit.APIinterface;
import katar.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewPasswordRepository {

    public static NewPasswordRepository newPasswordRepository;

    private APIinterface apIinterface;

    public  static NewPasswordRepository getInstance(){
        if ( newPasswordRepository ==null){
            newPasswordRepository = new NewPasswordRepository();
        }
        return newPasswordRepository;
    }



    public NewPasswordRepository(){
        apIinterface= RetrofitRequest.cteateService(APIinterface.class);
    }


    public Single<ChangePasswordModel>  sendnewPass(String phone, String code, String newpass)
    {
        return apIinterface.send_new_password(phone,code,newpass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
