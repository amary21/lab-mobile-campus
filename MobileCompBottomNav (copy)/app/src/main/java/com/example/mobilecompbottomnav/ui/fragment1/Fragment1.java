package com.example.mobilecompbottomnav.ui.fragment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobilecompbottomnav.R;
import com.example.mobilecompbottomnav.databinding.Fragment1FragmentBinding;
import com.example.mobilecompbottomnav.ui.activity.DetailActivity;
import com.example.mobilecompbottomnav.ui.fragmet4.Fragment4;

public class Fragment1 extends Fragment {

    private Fragment1ViewModel fragment1ViewModel;
    private Fragment1FragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = Fragment1FragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragment1ViewModel = new ViewModelProvider(this).get(Fragment1ViewModel.class);

        fragment1ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.fragment1TextMessage.setText(binding.fragment1EdMessage.getText().toString());
            }
        });

        binding.fragment1ButtonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), binding.fragment1EdMessage.getText(), Toast.LENGTH_SHORT).show();
                fragment1ViewModel.setData(binding.fragment1TextMessage.getText().toString());
            }
        });

        binding.btnToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment4 fragment4 = new Fragment4();

                Bundle mBundle = new Bundle();
                mBundle.putString("key_fragment", "Data dengan fragment");

                fragment4.setArguments(mBundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_main_nav_host_fragment, fragment4, Fragment4.class.getSimpleName());
                fragmentTransaction.commit();
            }
        });

        binding.btnToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("key_activity", "Data dengan activity");
                startActivity(intent);
            }
        });
    }
}