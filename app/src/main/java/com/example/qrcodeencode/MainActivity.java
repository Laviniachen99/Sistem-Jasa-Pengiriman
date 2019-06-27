package com.example.qrcodeencode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button read_btn;
    private Button  gen_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read_btn = (Button) findViewById(R.id.read_btn);
        gen_btn = (Button) findViewById(R.id.gen_btn);
        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReadingActivity.class);
                startActivity(intent);
            }
        });
        gen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,GenerateActivity.class);
                startActivity(intent2);
            }
        });
        
    }
}
