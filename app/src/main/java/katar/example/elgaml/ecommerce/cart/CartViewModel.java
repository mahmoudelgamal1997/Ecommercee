package katar.example.elgaml.ecommerce.cart;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import katar.example.elgaml.ecommerce.model.Cart.CartResponse;
import katar.example.elgaml.ecommerce.repostiory.CartRepository;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;


public class CartViewModel extends ViewModel {

    CartRepository cartRepository;

    public  void init(){
        if(cartRepository==null){
            cartRepository = new CartRepository();
        }
    }
    public LiveData<CartResponse> getCart(String api_token){
        final MutableLiveData<CartResponse> mutableLiveData = new MutableLiveData<>();
        cartRepository.getCart(api_token).subscribe(new SingleObserver<CartResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(CartResponse cartResponse) {
                mutableLiveData.setValue(cartResponse);
            }
            @Override
            public void onError(Throwable e) {
                Log.e("ERrorrrr",e.getMessage());
            }
        });
        return mutableLiveData;
    }

    public LiveData<CartResponse> updateCart(String api_token,int quantity,int cart_id){
        final MutableLiveData<CartResponse> mutableLiveData = new MutableLiveData<>();
        cartRepository.update( api_token, quantity, cart_id).subscribe(new SingleObserver<CartResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(CartResponse cartResponse) {
                mutableLiveData.setValue(cartResponse);
            }
            @Override
            public void onError(Throwable e) {
                Log.e("ERrorrrr",e.getMessage());
            }
        });
        return mutableLiveData;
    }

    public LiveData<CartResponse> deleteCart(int cart_id,String api_token){
        final MutableLiveData<CartResponse> mutableLiveData = new MutableLiveData<>();
        cartRepository.deleteCart( cart_id , api_token).subscribe(new SingleObserver<CartResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(CartResponse cartResponse) {
                mutableLiveData.setValue(cartResponse);
            }
            @Override
            public void onError(Throwable e) {
                Log.e("ERrorrrr",e.getMessage());
            }
        });
        return mutableLiveData;
    }
}