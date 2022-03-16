package katar.example.elgaml.ecommerce.home;

import katar.example.elgaml.ecommerce.model.DealModel.DealResponse;
import katar.example.elgaml.ecommerce.model.FavouritModel.AddToFavourit;
import katar.example.elgaml.ecommerce.model.HomeModel.HomeTestResponse;
import katar.example.elgaml.ecommerce.retrofit.APIinterface;
import katar.example.elgaml.ecommerce.retrofit.RetrofitRequest;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HomeRepository {

    public static HomeRepository homeRepository;

    private APIinterface apIinterface;

    public HomeRepository() {
        apIinterface = RetrofitRequest.cteateService(APIinterface.class);
    }

    public Observable<HomeTestResponse> getHome() {
        return apIinterface.getHome( ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<AddToFavourit> addFavourit(String api_token, String productId) {
        return apIinterface.add_Favourit(api_token, productId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Observable<DealResponse> getDeals() {
        return apIinterface.getDeals().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
