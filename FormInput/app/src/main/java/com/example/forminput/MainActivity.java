package com.example.forminput;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.forminput.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    private EditText edtNama;
//    private Button btnPesan;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        edtNama = findViewById(R.id.edt_nama);
//        btnPesan = findViewById(R.id.btn_pesan);
//
//        btnPesan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("pemesanan", edtNama.getText().toString());
//            }
//        });
//    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("pemesanan", binding.edtNama.getText().toString());
            }
        });
    }
}




















