package com.example.elgaml.ecommerce.repostiory;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
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

    public Single<CartResponse> update(String api_token, int quantity, int cart_id){
        return apIinterface.updateCart(api_token,quantity,cart_id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<CartResponse> deleteCart(int cart_id,String api_token){
        return apIinterface.deleteCart(cart_id,api_token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
