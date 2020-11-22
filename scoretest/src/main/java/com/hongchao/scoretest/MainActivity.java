package com.hongchao.scoretest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import com.hongchao.scoretest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    ActivityMainBinding binding;
    final static String A_NUMBER = "A_number";
    final static String B_NUMBER = "B_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
//        if (savedInstanceState!=null){
//            myViewModel.getaTeamScore().setValue(savedInstanceState.getInt(A_NUMBER));
//            myViewModel.getbTeamScore().setValue(savedInstanceState.getInt(B_NUMBER));
//        }

        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(A_NUMBER,myViewModel.getaTeamScore().getValue());
//        outState.putInt(B_NUMBER,myViewModel.getbTeamScore().getValue());
//
//    }
}
