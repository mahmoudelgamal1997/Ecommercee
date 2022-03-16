package com.example.elgaml.ecommerce.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.auth.forgetpass.ForgetPassword;
import com.example.elgaml.ecommerce.auth.signup.SignUpActivity;
import com.example.elgaml.ecommerce.model.User;
import com.google.gson.Gson;

import static com.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;
import static com.example.elgaml.ecommerce.utils.Validation.isValidEmail;

public class LoginActivity extends AppCompatActivity  {


    private Button sign_in_button;
    private EditText name_editText,pass_editText;
    private TextView signup_text,foregetPasssword_text,email_wrong_toast;
    private LoginViewModel loginViewModel;
    private Toast toast;
    private static final String MY_PREFS_NAME ="UserAuth" ;
    SharedPreferences pref;
    SharedPreferences.Editor editor ;
    String USER_ID="UserId";
    String USER_NAME= "UserName";
    String USER_EMAIL="UserEmail";
    String USER_IMG="UserImage";
    String mUSER_Data ="UserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sign_in_button=(Button)findViewById(R.id.sign_in);
        name_editText=(EditText)findViewById(R.id.email_phone_login);
        pass_editText=(EditText)findViewById(R.id.passowrd_login);
        signup_text=(TextView)findViewById(R.id.sign_up_text);
        foregetPasssword_text= (TextView)findViewById(R.id.forget_password);
        email_wrong_toast = (TextView)findViewById(R.id.email_wrong_toast);
        loginViewModel=new LoginViewModel();
        loginViewModel.init();

        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Internet
                if (isNetworkAvailable(getApplicationContext())) {

                    String name = name_editText.getText().toString().trim();
                    String password = pass_editText.getText().toString().trim();

                    //hide error msg textview
                    email_wrong_toast.setVisibility(View.INVISIBLE);
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                        if (isValidEmail(name) || name.contains("0")) {
                            loginViewModel.signIn(name, password).observe(LoginActivity.this, new Observer<User>() {
                                @Override
                                public void onChanged(User user) {
                                    if (user != null) {
                                        //save state as login
                                        Gson gson=new Gson();
                                        String json=gson.toJson(user);
                                        editor.putString(mUSER_Data,json);
                                        editor.putBoolean("isExist", true); // Storing boolean
                                        editor.putString(USER_ID,user.getApiToken());
                                        editor.putString(USER_NAME,user.getName());
                                        editor.putString(USER_EMAIL,user.getEmail());
                                        editor.putString(USER_IMG,user.getImage());
                                        editor.apply();
                                        loginViewModel.goToHome(getCurrentFocus());
                                        finish();

                                    } else {
                                        // that means Email or password is wrong
                                        email_wrong_toast.setVisibility(View.VISIBLE);
                                        email_wrong_toast.setText("Email  or password is wrong");
                                    }
                                }
                            });

                        } else {
                            email_wrong_toast.setVisibility(View.VISIBLE);
                            email_wrong_toast.setText("invalid Email");
                        }
                    } else {
                        email_wrong_toast.setVisibility(View.VISIBLE);
                        email_wrong_toast.setText("please fill data");
                    }

                }else {
                    showToast("Internet disconnect");
                }
            }
        });



        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        foregetPasssword_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(LoginActivity.this, ForgetPassword.class);
                startActivity(intent);
                
            }
        });

    }

    void showToast(String msg){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        toast.show();
    }
}
