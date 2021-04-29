package com.example.mobilecompbottomnav.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mobilecompbottomnav.R;
import com.example.mobilecompbottomnav.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String text = getIntent().getStringExtra("key_activity");
        binding.tvActDetail.setText(text);
    }
}