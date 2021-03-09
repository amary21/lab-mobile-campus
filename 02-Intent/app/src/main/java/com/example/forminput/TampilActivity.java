package com.example.forminput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.forminput.databinding.ActivityTampilBinding;

public class TampilActivity extends AppCompatActivity {

    private ActivityTampilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTampilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ambil data dari intent yg dikirimkan dari activity sebelemuya
        Intent intent = getIntent();
        String message = intent.getStringExtra("key_message");

        //tampilkan message di textview
        binding.labelMessage.setText(message);
    }
}