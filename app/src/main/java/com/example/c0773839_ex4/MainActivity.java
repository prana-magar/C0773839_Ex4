package com.example.c0773839_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String[] COUNTRIES = new String[] {"Mr.", "Mrs.", "Ms.", "Miss." ,"Dr." ,"Sir Lord"};
    AutoCompleteTextView suffixAutoCompleteTextView;
    Button sendBtn;
    TextInputEditText  firstNameEditText;
    TextInputEditText  lastNameEditText;
    RadioGroup employementType;
    RadioButton selectedEmplyementTypeRadio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // suffix
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        R.layout.dropdown_menu_popup_item,
                        COUNTRIES);
        suffixAutoCompleteTextView = findViewById(R.id.suffixDropDownText);
        suffixAutoCompleteTextView.setAdapter(adapter);



        sendBtn = findViewById(R.id.textButtonSend);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // suffix
                suffixAutoCompleteTextView = findViewById(R.id.suffixDropDownText);
                String suffixString = suffixAutoCompleteTextView.getText().toString();
                Log.e("suffixString",suffixString);

                // firstname
                firstNameEditText = findViewById(R.id.firstNameText);
                lastNameEditText = findViewById(R.id.lastName);
                Log.e("name",firstNameEditText.getText().toString() + lastNameEditText.getText().toString());


                // employement type
                employementType = findViewById(R.id.employement_type);
                int selectedId = employementType.getCheckedRadioButtonId();
                selectedEmplyementTypeRadio = findViewById(selectedId);
                Log.e("employement Type ",selectedEmplyementTypeRadio.getText().toString());


                
            }
        });



    }
}
