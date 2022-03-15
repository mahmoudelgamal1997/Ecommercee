package com.example.elgaml.ecommerce.favourite;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouriteResponseItem;
import com.example.elgaml.ecommerce.repostiory.FavouritRepository;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FavouriteViewModel extends ViewModel {

    private FavouritRepository favouritRepository;

    void init(){
        if(favouritRepository==null){
            favouritRepository = new FavouritRepository();
        }
    }


    public LiveData<List<FavouriteResponseItem>> getFavourit(String api_token){
         final MutableLiveData<List<FavouriteResponseItem>> mutableLiveData = new MutableLiveData<>();
        favouritRepository.getFavourit(api_token).subscribe(new Observer<List<FavouriteResponseItem>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<FavouriteResponseItem> favouriteResponseItems) {
                mutableLiveData.setValue(favouriteResponseItems);
                           }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
        });
        return mutableLiveData;
    }

    public LiveData<CartResponse> add_to_cart( String api_token,
                                               String product_id){
        final MutableLiveData<CartResponse> mutableLiveData = new MutableLiveData<>();
        favouritRepository.add_to_cart(api_token,product_id).subscribe(new Observer<CartResponse>() {
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
