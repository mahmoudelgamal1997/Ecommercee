package com.example.elgaml.ecommerce.auth.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.Error;
import com.example.elgaml.ecommerce.model.SignUpErrorModel;
import com.example.elgaml.ecommerce.model.User;
import com.example.elgaml.ecommerce.repostiory.SignUpRepository;

import static com.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;
import static com.example.elgaml.ecommerce.utils.Validation.isValidEmail;
import static com.example.elgaml.ecommerce.utils.Validation.isValidPassword;

public class SignUpActivity extends AppCompatActivity  {

    SignUpViewModel signUpViewModel;
    EditText name_edittext,email_edittext,phone_edittext,password_edittext;
    Button signup_button;
    TextView signin_text,name_toast,email_toast,phone_toast,password_toast;
    Toast toast = null;
    boolean flag=true ;
    String mUSER_ID ="UserId";
    String mUSER_NAME = "UserName";
    String mUSER_EMAIL ="UserEmail";
    String mUSER_IMG ="UserImage";
    private static final String MY_PREFS_NAME ="UserAuth" ;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_sign_up);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });


        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideToast();

                flag=false;
                //check internet
                if (isNetworkAvailable(getApplicationContext())) {

                    String name = name_edittext.getText().toString();
                    String email = email_edittext.getText().toString();
                    String phone = phone_edittext.getText().toString();
                    String password = password_edittext.getText().toString();

                    if (name.contains("  ")){
                        name_toast.setVisibility(View.VISIBLE);
                        name_toast.setText("name is Invalid");
                        flag=true;
                    }
                    if (TextUtils.isEmpty(name)) {
                        name_toast.setVisibility(View.VISIBLE);
                        name_toast.setText("name is required");
                        flag=true;
                    }
                    if (TextUtils.isEmpty(phone)) {
                        phone_toast.setVisibility(View.VISIBLE);
                        phone_toast.setText("phone is required");
                        flag =true;
                    }
                    if (TextUtils.isEmpty(password)) {
                        password_toast.setVisibility(View.VISIBLE);
                        password_toast.setText("password is required");
                        flag=true;
                    }
                    if (TextUtils.isEmpty(email)) {
                        email_toast.setText("email is required");
                        email_toast.setVisibility(View.VISIBLE);
                        flag= true;
                    }

                    if (!isValidEmail(email)) {
                        email_toast.setText("Email is invalid");
                        email_toast.setVisibility(View.VISIBLE);
                        flag=true;
                    }

                    if (!isValidPassword(password) || password.length() <= 6  || TextUtils.isEmpty(password)) {
                        password_toast.setVisibility(View.VISIBLE);
                        flag=true;
                        if (!isValidPassword(password)){
                            password_toast.setText("password must contain lower,upper and special character ");
                        }
                        if (password.length() <= 6 ){
                            password_toast.setText("password must be at least 6 char");
                        }
                        if (TextUtils.isEmpty(password)){
                            password_toast.setText("password required");
                        }
                    }

        if (!flag) {
            signUpViewModel.signUp(name.trim(), email, phone, password)
                    .observe(SignUpActivity.this, new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            if (user!=null) {
                                Log.e("SignUP", user.getId().toString());
                                progressBar.setVisibility(View.VISIBLE);
                                // Storing boolean
                                signUpViewModel.editorSaveUser(MY_PREFS_NAME, SignUpActivity.this, "isExist", true);
                                signUpViewModel.editorSaveUserID(MY_PREFS_NAME , SignUpActivity.this, mUSER_ID,user.getApiToken());
                                signUpViewModel.editorSaveUserName(MY_PREFS_NAME,SignUpActivity.this, mUSER_NAME,user.getName());
                                signUpViewModel.editorSaveUserEmail(MY_PREFS_NAME,SignUpActivity.this, mUSER_EMAIL,user.getEmail());
                                signUpViewModel.editorSaveUserImage(MY_PREFS_NAME,SignUpActivity.this, mUSER_IMG,user.getImage());
                                signUpViewModel.goToHome(getCurrentFocus());
                                finish();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });

                        //to handle error form server
                        signUpViewModel.signUpErrorModel();
                        signUpViewModel.signuperror.observe(SignUpActivity.this, new Observer<SignUpErrorModel>() {
                            @Override
                            public void onChanged(SignUpErrorModel signUpErrorModel) {
                                if (signUpErrorModel != null) {
                                    progressBar.setVisibility(View.VISIBLE);

                                    Error msg = signUpErrorModel.getErrors().get(0);
                                    if (msg.getName().contains("name")) {
                                        name_toast.setVisibility(View.VISIBLE);
                                        name_toast.setText(msg.getMessage());
                                    }

                                    if (msg.getName().contains("email")) {
                                        email_toast.setVisibility(View.VISIBLE);
                                        email_toast.setText(msg.getMessage());
                                    }
                                    if (msg.getName().contains("phone")) {
                                        phone_toast.setVisibility(View.VISIBLE);
                                        phone_toast.setText(msg.getMessage());
                                    }
                                    if (msg.getName().contains("password")) {
                                        password_toast.setVisibility(View.VISIBLE);
                                        password_toast.setText(msg.getMessage());
                                    }

                                    signUpViewModel.signuperror.setValue(null);
                                    progressBar.setVisibility(View.INVISIBLE);
                                } }
                        });
                    }

                }else {

                showToast("Internet disconnect");
                }
            }});

        signin_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               signUpViewModel.goToLogin(view);
                finish();
            }
        });
    }

    void hideToast(){
        name_toast.setVisibility(View.INVISIBLE);
        email_toast.setVisibility(View.INVISIBLE);
        password_toast.setVisibility(View.INVISIBLE);
        phone_toast.setVisibility(View.INVISIBLE);
    }

    void init(){
        name_edittext=(EditText)findViewById(R.id.name_register);
        email_edittext=(EditText)findViewById(R.id.email_register);
        phone_edittext=(EditText)findViewById(R.id.phone_register);
        password_edittext=(EditText)findViewById(R.id.password_register);
        signup_button = (Button)findViewById(R.id.sign_up);
        signin_text=(TextView)findViewById(R.id.sign_in_text);
        name_toast=(TextView)findViewById(R.id.name_toast);
        email_toast=(TextView)findViewById(R.id.email_toast);
        phone_toast=(TextView)findViewById(R.id.phone_toast);
        password_toast=(TextView)findViewById(R.id.password_toast);
        progressBar = (ProgressBar)findViewById(R.id.progress_sign_up);
        signUpViewModel= new SignUpViewModel();
        signUpViewModel.init(SignUpRepository.getInstance());

    }

    void showToast(String msg){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        toast.show();
    }

}


