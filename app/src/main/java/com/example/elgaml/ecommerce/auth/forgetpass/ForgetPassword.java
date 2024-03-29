package com.example.elgaml.ecommerce.auth.forgetpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elgaml.ecommerce.R;
import com.example.elgaml.ecommerce.model.ForgetPasswordModel;

import static com.example.elgaml.ecommerce.utils.ProjectUtils.isNetworkAvailable;

public class ForgetPassword extends AppCompatActivity {

  private   EditText phone_editetext;
  private   Button   send_reset_button;
  private ForgetPasswordViewModel forgetPasswordViewModel;
  private ProgressBar progressBar;
  private Toast toast;
   TextView errormsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_forgot);
        setSupportActionBar(toolbar);
        phone_editetext= (EditText)findViewById(R.id.phone_forget);
        send_reset_button=(Button)findViewById(R.id.send_reset_button);
        progressBar      =(ProgressBar)findViewById(R.id.progressbar);
        errormsg         =(TextView)findViewById(R.id.errormsg);


        getSupportActionBar().setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                finish();
            }
        });

        forgetPasswordViewModel=new ForgetPasswordViewModel();
        forgetPasswordViewModel.init();
        phone_editetext.requestFocus();
        send_reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (isNetworkAvailable(getApplicationContext())) {
                    send_reset_button.setEnabled(false);
                    final String phone= phone_editetext.getText().toString();

                    if (!TextUtils.isEmpty(phone)) {

                    progressBar.setVisibility(View.VISIBLE);
                    forgetPasswordViewModel.resetPassword(phone);
                    forgetPasswordViewModel.mutableLiveDataForget.observe(ForgetPassword.this, new Observer<ForgetPasswordModel>() {
                    @Override
                    public void onChanged(ForgetPasswordModel forgetPasswordModel) {
                    if (forgetPasswordModel != null) {
                    showToast( forgetPasswordModel.getCode().toString());
                    forgetPasswordViewModel.goToConfirmForgot(getCurrentFocus(), phone, forgetPasswordModel.getCode());
                    progressBar.setVisibility(View.INVISIBLE);
                    finish();

                    } else {
                     progressBar.setVisibility(View.INVISIBLE);
                        showToast("Phone not found");
                    }

                    }
                    });
                    }else {
                       errormsg.setText("Enter your phone");
                    }

                }else {
                    showToast("Internet disconnect");
                    }
            }});
    }


        void showToast(String msg){
        if (toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        toast.show();
    }

}
