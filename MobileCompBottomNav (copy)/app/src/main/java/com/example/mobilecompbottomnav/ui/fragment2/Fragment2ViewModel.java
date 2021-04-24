package com.example.mobilecompbottomnav.ui.fragment2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Fragment2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Fragment2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}