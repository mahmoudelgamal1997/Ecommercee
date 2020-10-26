package com.example.elgaml.ecommerce.home;

import com.example.elgaml.ecommerce.model.DealModel.DealResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.HomeResponse;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomeRepository
{

    public static HomeRepository homeRepository;

    private APIinterface apIinterface;

    public HomeRepository(){
        apIinterface= RetrofitRequest.cteateService(APIinterface.class);
    }

    public Observable<HomeResponse> getHome(String api_token){

        return apIinterface.getHome(api_token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<AddToFavourit> addFavourit(String api_token, String productId){
        return apIinterface.add_Favourit(api_token,productId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Observable<DealResponse> getDeals(){
        return apIinterface.getDeals().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }



}
