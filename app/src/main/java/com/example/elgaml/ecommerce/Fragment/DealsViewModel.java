package com.example.elgaml.ecommerce.Fragment;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.Home.HomeRepository;
import com.example.elgaml.ecommerce.model.DealModel.DealResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DealsViewModel extends ViewModel {

    HomeRepository homeRepository;
    CompositeDisposable disposable;
    MutableLiveData<Throwable> throwableMutableLiveData;
    public void init(){
        if (homeRepository==null){
            homeRepository= new HomeRepository();
            throwableMutableLiveData= new MutableLiveData<>();
            disposable = new CompositeDisposable();
        }
    }


    public LiveData<DealResponse> getDeals(){
        final MutableLiveData<DealResponse> mutableLiveData = new MutableLiveData<>();
        homeRepository.getDeals().subscribe(new Observer<DealResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DealResponse dealResponse) {
                mutableLiveData.setValue(dealResponse);
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

    public LiveData<AddToFavourit> addFavourit(String api_token, String product_id) {
        final MutableLiveData<AddToFavourit> mutableLiveData = new MutableLiveData<>();

        homeRepository.addFavourit(api_token,product_id).subscribe(new SingleObserver<AddToFavourit>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(AddToFavourit addToFavourit) {
                mutableLiveData.setValue(addToFavourit);
                Log.e("doneee", addToFavourit.getMessage());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("errrrror",e.getMessage());
            }
        });
        return mutableLiveData;



    }

}
