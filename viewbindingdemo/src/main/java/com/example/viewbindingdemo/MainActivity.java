package com.example.viewbindingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.viewbindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textView1.setText("view");
        binding.textView2.setText("binding");

    }
}
