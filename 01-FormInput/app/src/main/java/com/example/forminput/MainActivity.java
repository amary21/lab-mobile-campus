package com.example.forminput;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.forminput.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
/**penggunaan findViewById*/
//    private EditText edtNama, edtTangalLahir;
//    private Button btnPesan;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        edtNama = findViewById(R.id.edt_nama);
//        edtTangalLahir = findViewById(R.id.edt_tanggal_lahir);
//        btnPesan = findViewById(R.id.btn_pesan);
//
//        btnPesan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String nama = edtNama.getText().toString();
//                String tglLahir = edtTangalLahir.getText().toString();
//
//                Log.d("LogMainActivity", "btnPesanClick -> " + nama + " " + tglLahir);
//                Toast.makeText(MainActivity.this, nama + " " + tglLahir, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    /**penggunaan viewBinding*/
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = binding.edtNama.getText().toString();
                String tglLahir = binding.edtTanggalLahir.getText().toString();

                Log.d("LogMainActivity", "btnPesanClick -> " + nama + " " + tglLahir);
                Toast.makeText(MainActivity.this, nama + " " + tglLahir, Toast.LENGTH_SHORT).show();
            }
        });
    }
}




















