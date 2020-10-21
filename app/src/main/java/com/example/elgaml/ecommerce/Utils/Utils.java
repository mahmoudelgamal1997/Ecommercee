package com.example.elgaml.ecommerce.Utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.elgaml.ecommerce.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Utils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

  public static void hideBottomNavigationBar(RecyclerView mRecyclerView, final BottomNavigationView bottom_navigation){
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && bottom_navigation.isShown()) {
                    bottom_navigation.setVisibility(View.GONE);
                } else if (dy < 0 ) {
                    bottom_navigation.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

  public static void showToast(String msg, Context context, Toast toast){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText((context),msg,Toast.LENGTH_SHORT);
        toast.show();
    }

  public static Animation makeAnimation(Context context) {
        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.love_animation);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        BonusInterpolator interpolator = new BonusInterpolator(0.3, 20);
        myAnim.setInterpolator(interpolator);
        return myAnim;
    }

}