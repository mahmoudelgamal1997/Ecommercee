package com.example.elgaml.ecommerce.repostiory;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouritResponse;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FavouritRepository {

    private APIinterface apIinterface;
    private FavouritRepository favouritRepository;
//    private CompositeDisposable compositeDisposable;
    public FavouritRepository getInstance(){
        if (favouritRepository==null){
            favouritRepository= new FavouritRepository();
//            compositeDisposable= new CompositeDisposable();
            return favouritRepository;
        }
        return favouritRepository;
    }

    public FavouritRepository(){
        apIinterface = RetrofitRequest.cteateService(APIinterface.class);
    }

    public Observable<FavouritResponse> getFavourit(String api_token){
        return apIinterface.getFavourit(api_token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<CartResponse> add_to_cart( String api_token,
                                                 String product_id,
                                                 String quantity,
                                                 String size_id,
                                                 String color_id){
        return apIinterface.add_to_cart(api_token,product_id,quantity,
                                        size_id,color_id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
