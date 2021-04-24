package com.example.mobilecompbottomnav.ui.fragment3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Fragment3ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Fragment3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment3 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}