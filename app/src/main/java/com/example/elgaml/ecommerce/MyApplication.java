package com.example.elgaml.ecommerce;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketException;

import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.HttpException;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RxJavaPlugins.setErrorHandler(e -> {
            if (e instanceof UndeliverableException) {
                e = e.getCause();
            }
            if ((e instanceof IOException) || (e instanceof SocketException)) {
                Log.e("a","a");
                // fine, irrelevant network problem or API that throws on cancellation
                return;
            }
            if (e instanceof InterruptedException) {
                Log.e("b","b");
                // fine, some blocking code was interrupted by a dispose call
                return;
            }
            if ((e instanceof NullPointerException) || (e instanceof IllegalArgumentException)) {
                // that's likely a bug in the application
                Log.e("c","c");
                return;
            }
            if (e instanceof IllegalStateException) {
                Log.e("d","d");
                // that's a bug in RxJava or in a custom operator
                return;
            }
            Log.e("Errorr", e.getMessage());

        });

    }
}

