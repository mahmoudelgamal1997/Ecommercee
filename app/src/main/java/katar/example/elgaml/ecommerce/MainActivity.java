package katar.example.elgaml.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.elgaml.ecommerce.R;

import katar.example.elgaml.ecommerce.home.Home;
import katar.example.elgaml.ecommerce.auth.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREFS_NAME ="UserAuth" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        boolean isExist = prefs.getBoolean("isExist", false);

        if (isExist){
            Intent intent =new Intent(MainActivity.this, Home.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent =new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
