package com.hongchao.viewmodeltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    private TextView textView;
    private Button button_1,button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
         button_1 = findViewById(R.id.button_1);
         button_2 = findViewById(R.id.button_2);
         textView = findViewById(R.id.textView);
         textView.setText(String.valueOf(myViewModel.number));
         button_1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 myViewModel.number++;
                 textView.setText(String.valueOf(myViewModel.number));
             }
         });
         button_2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 myViewModel.number = myViewModel.number + 2;
                 textView.setText(String.valueOf(myViewModel.number));
             }
         });
    }
}
