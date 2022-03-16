package com.example.elgaml.ecommerce.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.Cart.Product;
import com.example.elgaml.ecommerce.model.HomeModel.Image;
import com.example.elgaml.ecommerce.model.product.ProductResponse;
import com.example.elgaml.ecommerce.repostiory.ProductRepository;
import com.example.elgaml.ecommerce.retrofit.APIinterface;
import com.example.elgaml.ecommerce.retrofit.RetrofitRequest;
import com.example.elgaml.ecommerce.utils.ProjectUtils;

public class SingleProduct extends AppCompatActivity {

    TextView txt_error,product_title,product_tagline,product_release_date,product_stock
            ,product_price;
    ImageView iv_movie_poster;
    ProjectUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product);

        txt_error=findViewById(R.id.txt_error);
        product_title=findViewById(R.id.product_title);
        product_tagline=findViewById(R.id.product_tagline);
        product_release_date =findViewById(R.id.product_release_date);
        product_stock = findViewById(R.id.product_stock);
        product_price=findViewById(R.id.price_number);
        iv_movie_poster=findViewById(R.id.iv_movie_poster);
        utils=new ProjectUtils();

        Intent intent=getIntent();
        int id = (int) intent.getLongExtra("ProductID",664);
        APIinterface apIinterface= RetrofitRequest.cteateService(APIinterface.class);
        ProductRepository repository=new ProductRepository(apIinterface);
        ProductViewModel viewModel = new ProductViewModel(repository,this);
        viewModel.getProduct(id).observe(this, new Observer<ProductResponse>() {
            @Override
            public void onChanged(ProductResponse productResponse) {
                bindUI(productResponse);
            }
        });
    }

    public void bindUI(ProductResponse response){
        product_title.setText(response.product.name_en);
        product_stock.setText(response.product.stock+"");
        product_tagline.setText(response.product.today_offer);
        utils.loadImage(response.product.default_image,iv_movie_poster);
    }
}