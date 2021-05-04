package com.example.mobilecompbottomnav.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mobilecompbottomnav.R;
import com.example.mobilecompbottomnav.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        String text = getIntent().getStringExtra("key_activity");
        String text = DetailActivityArgs.fromBundle(getIntent().getExtras()).getName();
        Log.e("Detail", text );
        binding.tvActDetail.setText(text);
    }
}