package katar.example.elgaml.ecommerce.repostiory;


import katar.example.elgaml.ecommerce.model.ForgetPasswordModel;
import katar.example.elgaml.ecommerce.retrofit.APIinterface;
import katar.example.elgaml.ecommerce.retrofit.RetrofitRequest;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ForgetPasswordRepository
{
    public static ForgetPasswordRepository forgetPasswordRepository;

    private APIinterface apIinterface;

    public  static ForgetPasswordRepository getInstance(){
        if ( forgetPasswordRepository==null){
            forgetPasswordRepository= new ForgetPasswordRepository();
        }
        return forgetPasswordRepository;
    }



    public ForgetPasswordRepository(){
        apIinterface= RetrofitRequest.cteateService(APIinterface.class);
    }



    public Single<ForgetPasswordModel> send_reset(String phone)
    {
        return apIinterface.send_reset_password_code(phone)
                 .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
