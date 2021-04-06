package id.ac.uty.javarecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import id.ac.uty.javarecyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyListAdapter adapter = new MyListAdapter(setDataList());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setAdapter(adapter);
    }

    public DataList[] setDataList(){
        DataList[] myListData = new DataList[] {
                new DataList( R.drawable.img7, "Title 1", "20$"),
                new DataList( R.drawable.img8, "Title 2", "30$"),
                new DataList( R.drawable.img10, "Title 3", "40$"),
                new DataList( R.drawable.img11, "Title 3", "50$"),
                new DataList( R.drawable.img12, "Title 3", "60$")
        };
        return myListData;
    }
}
