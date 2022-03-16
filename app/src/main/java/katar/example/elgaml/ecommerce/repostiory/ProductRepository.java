package katar.example.elgaml.ecommerce.repostiory;

import androidx.lifecycle.MutableLiveData;

import katar.example.elgaml.ecommerce.model.product.ProductResponse;
import katar.example.elgaml.ecommerce.retrofit.APIinterface;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductRepository {

    APIinterface apIinterface;
   public ProductRepository(APIinterface apIinterface){
        this.apIinterface=apIinterface;
    }

    public MutableLiveData<ProductResponse> getProduct(int productID){
        MutableLiveData<ProductResponse> liveData=new MutableLiveData<>();
         apIinterface.getProduct(productID).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<ProductResponse>() {
             @Override
             public void onSubscribe(Disposable d) {

             }

             @Override
             public void onSuccess(ProductResponse productResponse) {
                liveData.setValue(productResponse);
             }

             @Override
             public void onError(Throwable e) {

             }
         });
         return  liveData;
    }

}
