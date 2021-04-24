package com.example.mobilecompbottomnav.ui.fragment1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Fragment1ViewModel extends ViewModel {

    private MutableLiveData<String> mText = new MutableLiveData<>();

    public LiveData<String> getText() {
        return mText;
    }

    public void setData(String text){
        mText.postValue(text);
    }
}