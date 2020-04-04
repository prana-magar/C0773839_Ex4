package com.example.c0773839_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0773839_ex4.Model.ComplainFile;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.detail);
        Intent mIntent = getIntent();
        ComplainFile complainFile = (ComplainFile) mIntent.getSerializableExtra("complainObj");
        tv.setText(complainFile.getPrintFormat());

    }
}
