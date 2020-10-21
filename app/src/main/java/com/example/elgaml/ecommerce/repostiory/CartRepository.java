package com.example.elgaml.ecommerce.repostiory;

import android.util.Log;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CartRepository {

   APIinterface apIinterface;
    public CartRepository(){
        apIinterface = RetrofitRequest.cteateService(APIinterface.class);
    }

    public Single<CartResponse> getCart(String api_token){
        return apIinterface.getCarts(api_token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
