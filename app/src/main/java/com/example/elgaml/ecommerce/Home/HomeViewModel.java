package com.example.elgaml.ecommerce.Home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import com.example.elgaml.ecommerce.model.HomeModel.HomeResponse;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class HomeViewModel extends ViewModel {

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


    public LiveData<HomeResponse> getHome(String api_token){
         final MutableLiveData<HomeResponse> mutableLiveData = new MutableLiveData<>();
       homeRepository.getHome(api_token).subscribe(new Observer<HomeResponse>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(HomeResponse homeModel) {

         mutableLiveData.setValue(homeModel);
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
            }

            @Override
            public void onError(Throwable e) {
                Log.e("errrrror",e.getMessage());
            }
        });
        return mutableLiveData;



    }
}
