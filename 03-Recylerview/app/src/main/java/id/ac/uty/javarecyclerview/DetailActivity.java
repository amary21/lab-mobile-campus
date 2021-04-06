package id.ac.uty.javarecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.ac.uty.javarecyclerview.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /** penggunaan not parcelable**/
//        binding.imageDetail.setImageResource(getIntent().getIntExtra("image", 0));
//        binding.priceDetail.setText(getIntent().getStringExtra("price"));
//        binding.titleDetail.setText(getIntent().getStringExtra("title"));

        /** penggunaan parcelable**/
        DataList dataList = getIntent().getParcelableExtra("data_list");
        binding.imageDetail.setImageResource(dataList.getImageId());
        binding.priceDetail.setText(dataList.getPrice());
        binding.titleDetail.setText(dataList.getTitle());

    }
}
