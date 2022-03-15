package com.example.elgaml.ecommerce.repostiory;

import com.example.elgaml.ecommerce.model.Cart.CartResponse;
import com.example.elgaml.ecommerce.model.FavouritModel.FavouriteResponseItem;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import java.util.List;

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

    public Observable<List<FavouriteResponseItem>> getFavourit(String api_token){
        return apIinterface.getFavourit(api_token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    public void getFavouritt(String api_token){
//         apIinterface.getFavourit(api_token).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FavouriteResponse>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(FavouriteResponse favouriteResponse) {
//                        Log.e("bbbbbb",favouriteResponse.getFavouriteResponse().toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    public Observable<CartResponse> add_to_cart(String api_token,
                                                String product_id){
        return apIinterface.add_to_cart(api_token,product_id,"1").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
