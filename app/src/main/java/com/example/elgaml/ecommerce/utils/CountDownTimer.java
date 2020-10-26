package com.example.elgaml.ecommerce.utils;

import androidx.lifecycle.MutableLiveData;

public class CountDownTimer extends android.os.CountDownTimer {

    private MutableLiveData<Boolean> finishLiveData = new MutableLiveData<>(false);
    private MutableLiveData<Integer> count = new MutableLiveData<>(30);

    public CountDownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);

    }

    @Override
    public void onTick(long l) {
        if (count.getValue()!=null &&count.getValue() != 0){
        count.setValue((count.getValue()-1));
    }
    }

    public MutableLiveData<Integer> getCount() {
        return count;
    }

    @Override
    public void onFinish() {
        finishLiveData.setValue(true);
        count.setValue(30);
        }

    public MutableLiveData<Boolean> getFinishLiveData() {
        return finishLiveData;
    }
}
