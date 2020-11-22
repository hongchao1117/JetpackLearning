package com.hongchao.livedatatest;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.hongchao.livedatatest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewModelWithLiveData liveData;
    //    TextView textView;
//    ImageButton likeButton,dislikeButton;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.textview);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        likeButton = findViewById(R.id.redButton);
//        dislikeButton = findViewById(R.id.blueButton);
        liveData = new ViewModelProvider(this).get(ViewModelWithLiveData.class);
        liveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.textview.setText(String.valueOf(integer));
            }
        });
        binding.redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveData.add(1);
            }
        });
        binding.blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveData.add(-1);
            }
        });
    }
}
