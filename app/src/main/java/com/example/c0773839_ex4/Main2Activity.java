package com.example.c0773839_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.c0773839_ex4.Model.ComplainFile;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mIntent = getIntent();
        ComplainFile complainFile = (ComplainFile) mIntent.getSerializableExtra("complainObj");
        Toast.makeText(Main2Activity.this,complainFile.getFirstName(),Toast.LENGTH_LONG).show();
    }
}
