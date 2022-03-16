package com.example.elgaml.ecommerce.product;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.elgaml.ecommerce.model.product.ProductResponse;
import com.example.elgaml.ecommerce.repostiory.ProductRepository;

public class ProductViewModel extends ViewModel {
   private ProductRepository repository;
   private LifecycleOwner lifecycleOwner;
    ProductViewModel(ProductRepository repository, LifecycleOwner lifecycleOwner){
        this.repository=repository;
        this.lifecycleOwner=lifecycleOwner;
    }

    public MutableLiveData<ProductResponse> getProduct(int productID){
         MutableLiveData<ProductResponse> liveData = new MutableLiveData<>();
        repository.getProduct(productID).observe(lifecycleOwner, new Observer<ProductResponse>() {
            @Override
            public void onChanged(ProductResponse productResponse) {
                liveData.setValue(productResponse);
            }
        });
        return liveData;
    }
}
