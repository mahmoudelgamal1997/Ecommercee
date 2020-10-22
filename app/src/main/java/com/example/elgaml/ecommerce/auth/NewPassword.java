package com.example.elgaml.ecommerce.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.ChangePasswordModel;

import static com.example.elgaml.ecommerce.Utils.Validation.isValidPassword;


public class NewPassword extends AppCompatActivity {

    EditText newpass,confirmnewpass;
    Button confirm_button;
    NewPasswordViewModel newPasswordViewModel;
    Toast toast;
    private static final String MY_PREFS_NAME ="UserAuth" ;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String USER_ID="UserId";
    String USER_NAME= "UserName";
    String USER_EMAIL="UserEmail";
    String USER_IMG="UserImage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        newpass = (EditText)findViewById(R.id.newpassword);
        confirmnewpass = (EditText)findViewById(R.id.confirmnewpassword);
        confirm_button = (Button)findViewById(R.id.confirm_button);


        pref = getApplicationContext().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = pref.edit();

        Intent intent =getIntent();
        final int code= intent.getIntExtra( "Code",0000);
        final String phone= intent.getStringExtra("Phone");


        newPasswordViewModel= new NewPasswordViewModel();
        newPasswordViewModel.init();

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = newpass.getText().toString();
                String confirmpassword = confirmnewpass.getText().toString();
                if (isValidPassword(password)) {
                 if (password.equals(confirmpassword)) {
                    // send request
                     newPasswordViewModel.sendnewPass(phone,String.valueOf(code),password);
                     newPasswordViewModel.mutableLiveData.observe(NewPassword.this, new Observer<ChangePasswordModel>() {
                         @Override
                         public void onChanged(ChangePasswordModel changePasswordModel)
                         {
                             showToast("Welcome again");
                             newPasswordViewModel.goToHome(getCurrentFocus());
                             editor.putBoolean("isExist", true);// Storing boolean
                             editor.putString(USER_ID,changePasswordModel.getUser().getApiToken());
                             editor.putString(USER_NAME,changePasswordModel.getUser().getName());
                             editor.putString(USER_EMAIL,changePasswordModel.getUser().getEmail());
                             editor.putString(USER_IMG,changePasswordModel.getUser().getImage());
                             editor.apply();
                             finish();
                            }
                     });

                } else {
                     showToast("field doesn't match");
                }
            }else{
                    showToast("Invalid password");
                }
            }
        });



    }
    void showToast(String msg){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();
    }
}
