package katar.example.elgaml.ecommerce.repostiory;

import katar.example.elgaml.ecommerce.model.MyAccountModel.UserResponse;
import katar.example.elgaml.ecommerce.retrofit.APIinterface;
import katar.example.elgaml.ecommerce.retrofit.RetrofitRequest;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyAccountRepository  {

    APIinterface apIinterface;
  public   MyAccountRepository(){
            apIinterface = RetrofitRequest.cteateService(APIinterface.class);
   }

   public Single<UserResponse> getProfile(String api_token){
    return apIinterface.getProfile(api_token)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread());
   }
}
