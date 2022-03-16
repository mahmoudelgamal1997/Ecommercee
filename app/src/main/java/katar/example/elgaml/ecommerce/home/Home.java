package katar.example.elgaml.ecommerce.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import katar.example.elgaml.ecommerce.cart.CartFragment;
import katar.example.elgaml.ecommerce.deals.DealsFragment;
import katar.example.elgaml.ecommerce.favourite.FavouriteFragment;
import katar.example.elgaml.ecommerce.myaccount.MyAccountFragment;
import katar.example.elgaml.ecommerce.noconnection.NoConnectionFragment;
import katar.example.elgaml.ecommerce.homefragment.HomeFragment;
import com.example.elgaml.ecommerce.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import katar.example.elgaml.ecommerce.utils.ProjectUtils;

public class Home extends AppCompatActivity {

    HomeFragment homeFragment;
    FavouriteFragment favouriteFragment;
    CartFragment cartFragment;
    DealsFragment dealsFragment;
    MyAccountFragment accountfrgament;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view_bar);
        final NoConnectionFragment noConnectionFragment = new NoConnectionFragment();

        if (ProjectUtils.isNetworkAvailable(this)) {
            //init state is home fragment
            HomeFragment frgament = new HomeFragment();
            changeFrgment(frgament);
        } else {
            changeFrgment(noConnectionFragment);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_icon: {
                        if (ProjectUtils.isNetworkAvailable(Home.this)) {
                            if (homeFragment == null) {
                                homeFragment = new HomeFragment();
                            }
                            changeFrgment(homeFragment);
                            return true;
                        } else {
                            changeFrgment(noConnectionFragment);
                        }
                    }
                    case R.id.favourit_icon: {
                        if (ProjectUtils.isNetworkAvailable(Home.this)) {
                            if (favouriteFragment == null) {
                                favouriteFragment = new FavouriteFragment();
                            }
                            changeFrgment(favouriteFragment);
                            return true;
                        } else {
                            changeFrgment(noConnectionFragment);
                        }
                    }
                    case R.id.cart_icon: {
                        if (ProjectUtils.isNetworkAvailable(Home.this)) {
                            if (cartFragment == null) {
                                cartFragment = new CartFragment();
                            }
                            changeFrgment(cartFragment);
                            return true;
                        } else {
                            changeFrgment(noConnectionFragment);

                        }
                    }

                    case R.id.deals: {
                        if (ProjectUtils.isNetworkAvailable(Home.this)) {
                            if (dealsFragment == null) {
                                dealsFragment = new DealsFragment();
                            }
                            changeFrgment(dealsFragment);
                            return true;
                        } else {
                            changeFrgment(noConnectionFragment);

                        }
                    }

                    case R.id.account: {
                        if (ProjectUtils.isNetworkAvailable(Home.this)) {
                            if (accountfrgament == null) {
                                accountfrgament = new MyAccountFragment();
                            }
                            changeFrgment(accountfrgament);
                            return true;
                        } else {
                            changeFrgment(noConnectionFragment);
                        }
                    }
                }
                return true;
            }
        });
    }


    void changeFrgment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }}