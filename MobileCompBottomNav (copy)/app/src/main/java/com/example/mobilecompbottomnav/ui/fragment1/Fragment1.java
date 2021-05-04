package com.example.mobilecompbottomnav.ui.fragment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.mobilecompbottomnav.R;
import com.example.mobilecompbottomnav.databinding.Fragment1FragmentBinding;
import com.example.mobilecompbottomnav.ui.detail.DetailActivity;
import com.example.mobilecompbottomnav.ui.detail.FragmentDetail;

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
        /**VIEW MODEL**/
        //inisialisasi viewmodel di dalam fragment
        fragment1ViewModel = new ViewModelProvider(this).get(Fragment1ViewModel.class);

        //implementasi observer viewmodel untuk mengambil data
        fragment1ViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.fragment1TextMessage.setText(binding.fragment1EdMessage.getText().toString());
            }
        });

        //implementasi untuk memasukkan data ke dalam viewmodel
        binding.fragment1ButtonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), binding.fragment1EdMessage.getText(), Toast.LENGTH_SHORT).show();
                fragment1ViewModel.setData(binding.fragment1TextMessage.getText().toString());
            }
        });


        /**TRANSACTION FRAGMENT TO FRAGMENT & FRAGMENT TO ACTIVITY**/
        //transaksi fragment to fragment tanpa komponen navigasi
        binding.btnToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDetail fragment4 = new FragmentDetail();

                Bundle mBundle = new Bundle();
                mBundle.putString("key_fragment", "Data dengan fragment");

                fragment4.setArguments(mBundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_main_nav_host_fragment, fragment4, FragmentDetail.class.getSimpleName());
                fragmentTransaction.commit();
            }
        });

        //transaksi fragment to activity tanpa komponen navigasi
        binding.btnToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("key_activity", "Data dengan activity");
                startActivity(intent);
            }
        });

        //transaksi fragment to fragment dengan komponen navigasi
        binding.btnToFragmentNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle mBundle = new Bundle();
                mBundle.putString("key_fragment", "Data dengan fragment");
                Navigation.findNavController(v).navigate(R.id.action_fragment1_to_fragmentDetail, mBundle);//R.id.action_fragment1_to_fragmentDetail didapat dari res->navigation->mobile_navigation.xml
            }
        });

        //transaksi fragment to activity dengan komponen navigasi
        binding.btnToActivityNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1Directions.ActionFragment1ToDetailActivity actionFragment1ToDetailActivity = Fragment1Directions.actionFragment1ToDetailActivity();
                actionFragment1ToDetailActivity.setName("uty");
                Navigation.findNavController(v).navigate(actionFragment1ToDetailActivity);//R.id.action_fragment1_to_detailActivity didapat dari res->navigation->mobile_navigation.xml
            }
        });


    }
}