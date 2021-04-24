package com.example.mobilecompbottomnav.ui.fragmet4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilecompbottomnav.R;
import com.example.mobilecompbottomnav.databinding.Fragment1FragmentBinding;
import com.example.mobilecompbottomnav.databinding.Fragment4Binding;

public class Fragment4 extends Fragment {


    private Fragment4Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment4Binding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            String text = getArguments().getString("key_fragment");
            binding.tvDetail.setText(text);
        }
    }
}