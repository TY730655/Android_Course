package com.example.bookbuy.ui.deposit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DepositViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DepositViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Deposit fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}