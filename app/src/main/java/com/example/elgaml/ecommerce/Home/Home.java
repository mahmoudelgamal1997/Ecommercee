package com.example.elgaml.ecommerce.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.elgaml.ecommerce.Fragment.CartFragment;
import com.example.elgaml.ecommerce.Fragment.DealsFragment;
import com.example.elgaml.ecommerce.Fragment.FavouritFragment;
import com.example.elgaml.ecommerce.Fragment.MyAccountFragment;
import com.example.elgaml.ecommerce.Fragment.MyAccountViewModel;
import com.example.elgaml.ecommerce.Fragment.NoConnectionFragment;
import com.example.elgaml.ecommerce.Fragment.homeFrgament;
import com.example.elgaml.ecommerce.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import static com.example.elgaml.ecommerce.Utils.Utils.isNetworkAvailable;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view_bar);
        final NoConnectionFragment noConnectionFragment=new NoConnectionFragment();

        if (isNetworkAvailable(this)) {
            //init state is home fragment
            homeFrgament frgament = new homeFrgament();
            changeFrgment(frgament);
        }else{
            changeFrgment(noConnectionFragment);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_icon: {
                if (isNetworkAvailable(Home.this)){
                homeFrgament frgament=new homeFrgament();
                changeFrgment(frgament);
                return true;
                }else {
                    changeFrgment(noConnectionFragment);
                }
            }
            case R.id.favourit_icon: {
                if (isNetworkAvailable(Home.this)) {
                    FavouritFragment frgament =new FavouritFragment();
                    changeFrgment(frgament);
                    return true;
                }else {
                    changeFrgment(noConnectionFragment);
                }
            }
            case R.id.cart_icon: {
                if ( isNetworkAvailable(Home.this)) {
                    CartFragment frgament = new CartFragment();
                    changeFrgment(frgament);
                    return true;
                }else {
                    changeFrgment(noConnectionFragment);

                }}

            case R.id.deals: {
                if ( isNetworkAvailable(Home.this)) {
                    DealsFragment frgament = new DealsFragment();
                    changeFrgment(frgament);
                    return true;
                } else {
                    changeFrgment(noConnectionFragment);

                }}

            case R.id.account: {
                if (isNetworkAvailable(Home.this)) {
                    MyAccountFragment frgament = new MyAccountFragment();
                    changeFrgment(frgament);
                    return true;
                }else {
                    changeFrgment(noConnectionFragment);

                } } }
            return true;
            }
        });
    }

    void changeFrgment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }

}
