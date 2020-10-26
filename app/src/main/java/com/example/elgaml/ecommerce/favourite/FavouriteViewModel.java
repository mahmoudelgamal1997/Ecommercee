package com.example.elgaml.ecommerce.favourite;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouritResponse;
import com.example.elgaml.ecommerce.repostiory.FavouritRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FavouriteViewModel extends ViewModel {

    private FavouritRepository favouritRepository;

    void init(){
        if(favouritRepository==null){
            favouritRepository = new FavouritRepository();
        }
    }


    public LiveData<FavouritResponse> getFavourit(String api_token){
        final MutableLiveData<FavouritResponse> mutableLiveData = new MutableLiveData<>();
        favouritRepository.getFavourit(api_token).subscribe(new Observer<FavouritResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FavouritResponse favouritResponse) {

                mutableLiveData.setValue(favouritResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("ERrorrrr",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }

    public LiveData<CartResponse> add_to_cart( String api_token,
                                               String product_id,
                                               String quantity,
                                               String size_id,
                                               String color_id){
        final MutableLiveData<CartResponse> mutableLiveData = new MutableLiveData<>();
        favouritRepository.add_to_cart(api_token,product_id,quantity,size_id,color_id).subscribe(new Observer<CartResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(CartResponse favouritResponse) {

                mutableLiveData.setValue(favouritResponse);

            }

            @Override
            public void onError(Throwable e) {
                Log.e(
                        "ERrorrrr",e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }


}
