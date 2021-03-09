package com.example.forminput;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.forminput.databinding.ActivityMainBinding;

import java.util.Calendar;

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
    private String nama, tglLahir, jenisKeleamin, paketWisata, paketTambahan, waktuPickup;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.edtTanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int tahun = calendar.get(Calendar.YEAR);
                int bulan = calendar.get(Calendar.MONTH);
                int hari = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                binding.edtTanggalLahir.setText(day + "-" + month + "-" + year);
                            }
                        }, tahun, bulan, hari);
                datePickerDialog.show();
            }
        });

        binding.edPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mTimeNow = Calendar.getInstance();
                int jam = mTimeNow.get(Calendar.HOUR_OF_DAY);
                int menit = mTimeNow.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int jam, int minute) {
                                binding.edPickup.setText(jam + ":" + minute);
                            }
                        }, jam, menit, true);
                timePickerDialog.show();
            }
        });

        binding.btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ambil data dari edittext
                nama = binding.edtNama.getText().toString();
                tglLahir = binding.edtTanggalLahir.getText().toString();

                //ambil data dari radiogroup dan radiobutton
                int statusJK = binding.rgGender.getCheckedRadioButtonId();
                jenisKeleamin = "";
                if (statusJK == R.id.rb_laki) {jenisKeleamin = "Laki-laki";}
                else if (statusJK == R.id.rb_perempuan) {jenisKeleamin = "Perempuan";}

                //ambil data dari spinner
                paketWisata = binding.spPaket.getSelectedItem().toString();

                //ambil data dari checkbox
                paketTambahan = "";
                if (binding.cbPerjalanan.isChecked()) {paketTambahan += binding.cbPerjalanan.getText().toString() + "\n";}
                if (binding.cbMakan.isChecked()){paketTambahan += binding.cbMakan.getText().toString() + "\n";}
                if (binding.cbMinum.isChecked()){paketTambahan += binding.cbMinum.getText().toString() + "\n";}

                waktuPickup = binding.edPickup.getText().toString();

                String message = nama + "\n"
                        + tglLahir + "\n"
                        + jenisKeleamin + "\n"
                        + paketWisata + "\n"
                        + paketTambahan + "\n"
                        + waktuPickup;

                Log.d("LogActivityMain", "btnPesaonClick: " + message);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

                //deklasrasi intent untuk membuka tampil activity
                Intent intent = new Intent(MainActivity.this, TampilActivity.class);
                //jika intent membawa data
                intent.putExtra("key_message", message);
                startActivity(intent);
            }
        });
    }
}




















