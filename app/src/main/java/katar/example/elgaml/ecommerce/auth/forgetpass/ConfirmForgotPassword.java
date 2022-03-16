package katar.example.elgaml.ecommerce.auth.forgetpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import katar.example.elgaml.ecommerce.utils.CountDownTimer;
import com.example.elgaml.ecommerce.R;
import katar.example.elgaml.ecommerce.model.ForgetPasswordModel;
import com.goodiebag.pinview.Pinview;

import katar.example.elgaml.ecommerce.utils.ProjectUtils;

public class ConfirmForgotPassword extends AppCompatActivity {


    TextView skip,pintoast;
    ConfirmPasswordViewModel viewModelConfirm;
    Button resend;
    long allTime = 30 * 1000;
    long timeInterval = 1000;
    MutableLiveData<Integer> codeMutableLiveData=new MutableLiveData<>();
    private Toast toast;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_forgor_password);

        viewModelConfirm = new ConfirmPasswordViewModel();
        viewModelConfirm.init();
        skip      = (TextView)findViewById(R.id.skip);
        resend    =(Button)findViewById(R.id.resend_reset_button);
        pintoast = (TextView)findViewById(R.id.pin_toast);
        progressBar = (ProgressBar) findViewById(R.id.progress_resend);

        final Pinview pin = (Pinview) findViewById(R.id.pinview);
        pin.requestFocus();
        Intent intent = getIntent();
        final int code = intent.getIntExtra("Code", 0000);
        final String phone = intent.getStringExtra("Phone");

        codeMutableLiveData.setValue(code);

        final CountDownTimer countDownTimer=new CountDownTimer(allTime, timeInterval);
        countDownTimer.cancel();
        countDownTimer.start();

        resend.setEnabled(false);
        countDownTimer.getFinishLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
              if (aBoolean){
                  resend.setEnabled(true);
                  resend.setText("Resend");

              } }});


        //resend button click
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ProjectUtils.isNetworkAvailable(getApplicationContext())) {
                    pintoast.setText("");
                    resend.setEnabled(false);
                    progressBar.setVisibility(View.VISIBLE);
                    viewModelConfirm.resetPassword(phone).observe(ConfirmForgotPassword.this, new Observer<ForgetPasswordModel>() {
                        @Override
                        public void onChanged(ForgetPasswordModel forgetPasswordModel) {
                            if (forgetPasswordModel != null) {
                                codeMutableLiveData.setValue(forgetPasswordModel.getCode());
                                showToast(forgetPasswordModel.getCode() + "");
                                resend.setEnabled(false);
                                countDownTimer.cancel();
                                countDownTimer.start();
                                countDownTimer.getFinishLiveData().setValue(false);
                                progressBar.setVisibility(View.INVISIBLE);
                            }else {
                                Log.e("Sending code",forgetPasswordModel.getMessage());
                            }
                        }
                    });

                }else {
                    showToast("Internet disconnect");
                }

            }
                    });
        // write time in text
        countDownTimer.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                resend.setText(integer+" s");
                if (integer==30){
                    resend.setText("resend");
                }

            }
        });


        // PIN Listener
        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(final Pinview pinview, boolean fromUser) {
                //Make api calls here or what not
                codeMutableLiveData.observe(ConfirmForgotPassword.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        if (Integer.parseInt(pinview.getValue())== integer) {
                            viewModelConfirm.goToNewPassword(getCurrentFocus(), phone, integer);
                        }else {
                            pintoast.setVisibility(View.VISIBLE);
                            pintoast.setText("Wrong Code");
                            pinview.clearValue();
                        }
                    }
                });

            }
        });


        skip.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View view) {
                viewModelConfirm.goToLogin(view.getRootView());
                finish();
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
