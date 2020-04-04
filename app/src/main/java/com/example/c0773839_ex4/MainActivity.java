package com.example.c0773839_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.c0773839_ex4.Model.ComplainFile;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener{

    String[] COUNTRIES = new String[] {"Mr.", "Mrs.", "Ms.", "Miss." ,"Dr." ,"Sir Lord"};

    AutoCompleteTextView suffixAutoCompleteTextView;
    Button sendBtn;
    Button clearBtn;
    TextInputEditText  firstNameEditText;
    TextInputEditText  lastNameEditText;
    RadioGroup employementType;
    RadioButton selectedEmplyementTypeRadio;
    AutoCompleteTextView designation;
    String[] DESIGNATIONS = new String[] {"Software Engineer", "Sr. Software Engineer", "Project Manager",
            "Support Engineer", "Designer", "Marketing"};

    TextInputEditText unitNoEditText;
    TextInputEditText streetNoEditText;
    TextInputEditText streetAddresEditText;

    TextInputEditText cityEditText;
    TextInputEditText provinceEditText;
    TextInputEditText countryEditText;

    TextInputEditText postalCodeEditText;

    TextInputEditText emailEditText;

    TextInputEditText phoneCodeEditText;
    TextInputEditText phoneNumberEditText;

    TextInputEditText issueDateEditText;
    TextInputLayout issueDate;

    AutoCompleteTextView issueTypeAutoComplete;
    String[] ISSUETYPE = new String[] {"Network Problem", "System Crashing", "Slow Internet", "Software Installation"};

    RatingBar severityRating;


    TextInputEditText description;







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


        ArrayAdapter<String> designationAdapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        R.layout.dropdown_menu_popup_item,
                        DESIGNATIONS);
        designation = findViewById(R.id.designation_dropdown);
        designation.setAdapter(designationAdapter);

        firstNameEditText = findViewById(R.id.firstNameText);
        lastNameEditText = findViewById(R.id.lastName);
        employementType = findViewById(R.id.employement_type);
        designation = findViewById(R.id.designation_dropdown);
        unitNoEditText = findViewById(R.id.unitNoEditText);
        streetNoEditText = findViewById(R.id.streetNoEditText);
        streetAddresEditText = findViewById(R.id.streetNameEditText);

        cityEditText = findViewById(R.id.cityEditText);
        provinceEditText = findViewById(R.id.provinceEditText);
        countryEditText = findViewById(R.id.countryEditText);

        postalCodeEditText = findViewById(R.id.postal_codeEditText);

        emailEditText = findViewById(R.id.emailEditText);

        phoneCodeEditText = findViewById(R.id.countryCodeEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);

        issueDateEditText = findViewById(R.id.issueDateEditText);


        issueDate = findViewById(R.id.issueDate);
        final MaterialDatePicker datePicker = new MaterialDatePicker();

        issueDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });





        issueTypeAutoComplete = findViewById(R.id.issueTypeDropDownText);

        ArrayAdapter<String> issueTypeAdapter =
                new ArrayAdapter<String>(
                        MainActivity.this,
                        R.layout.dropdown_menu_popup_item,
                        ISSUETYPE);
        issueTypeAutoComplete.setAdapter(issueTypeAdapter);

        severityRating = findViewById(R.id.ratingBar);
        severityRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float ratingValue = severityRating.getRating();

                String color = "green";
                if(ratingValue <= 1){
                    color = "black";
                }
                else if(ratingValue> 1 && ratingValue <= 2){
                    color = "green";
                }
                else if(ratingValue> 2 && ratingValue <= 3){
                    color = "yellow";
                }
                else if(ratingValue> 3 && ratingValue <= 4){
                    color = "magenta";
                }
                else {
                    color = "red";
                }

                LayerDrawable starLayer = (LayerDrawable)severityRating.getProgressDrawable();
                starLayer.getDrawable(2).setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);


            }
        });


        description = findViewById(R.id.descEditText);





        sendBtn = findViewById(R.id.textButtonSend);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isValidation()){
                    Toast.makeText(MainActivity.this,"Some of the field is incorrect. please see error msg",Toast.LENGTH_LONG).show();
                    return;

                }

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Alert")
                        .setMessage("ConFIRM?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveNext();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();



            }
        });


        clearBtn = findViewById(R.id.textButtonClear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearForm((ViewGroup) findViewById(R.id.container));
            }
        });


    }

    public void moveNext(){
        ComplainFile complainFile = new ComplainFile();
        // suffix
        suffixAutoCompleteTextView = findViewById(R.id.suffixDropDownText);
        String suffixString = suffixAutoCompleteTextView.getText().toString();
        Log.e("suffixString",suffixString);
        complainFile.setSuffix(suffixString);

        // firstname

        complainFile.setFirstName(firstNameEditText.getText().toString());
        Log.e("name",firstNameEditText.getText().toString() + lastNameEditText.getText().toString());

        // lastname
        complainFile.setLastName(lastNameEditText.getText().toString());

        // employement type

        int selectedId = employementType.getCheckedRadioButtonId();
        selectedEmplyementTypeRadio = findViewById(selectedId);
        Log.e("employement Type ",selectedEmplyementTypeRadio.getText().toString());
        complainFile.setEmployementType(selectedEmplyementTypeRadio.getText().toString());

        // designation

        String designationString = designation.getText().toString();
        Log.e("designationString",designationString);
        complainFile.setDesignation(designationString);

        //
        Log.e("name",unitNoEditText.getText().toString());
        complainFile.setUnitNo(unitNoEditText.getText().toString());

        complainFile.setStreetNo(streetNoEditText.getText().toString());
        complainFile.setStreetName(streetAddresEditText.getText().toString());

        complainFile.setCity(cityEditText.getText().toString());
        complainFile.setProvince(provinceEditText.getText().toString());
        complainFile.setCountry(countryEditText.getText().toString());

        complainFile.setPostalCode(postalCodeEditText.getText().toString());
        complainFile.setEmail(emailEditText.getText().toString());
        complainFile.setCountryCode(phoneCodeEditText.getText().toString());
        complainFile.setPhoneNumber(phoneNumberEditText.getText().toString());
        complainFile.setCountry(countryEditText.getText().toString());

        complainFile.setIssueDate(issueDateEditText.getText().toString());
        complainFile.setIssueType(issueTypeAutoComplete.getText().toString());

        complainFile.setSevRating(severityRating.getRating());
        complainFile.setDescription(description.getText().toString());

        Intent mIntent = new Intent(MainActivity.this,Main2Activity.class);
        mIntent.putExtra("complainObj",complainFile);
        startActivity(mIntent);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String dateStr = year+"/"+month+"/"+dayOfMonth;
        issueDateEditText.setText(dateStr);
    }


    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof TextInputEditText) {
                ((TextInputEditText)view).setText("");
            }

            if (view instanceof AutoCompleteTextView) {
                ((AutoCompleteTextView)view).setText("");
            }
            if (view instanceof RatingBar) {
                ((RatingBar)view).setRating(0.0F);
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }

    private Boolean isValidation(){
        if (firstNameEditText.getText().toString().trim().isEmpty()){
            firstNameEditText.setError("First Name cant be Empty");
            return false;
        }

        if (lastNameEditText.getText().toString().trim().isEmpty()){
            lastNameEditText.setError("Last Name cant be Empty");
            return false;
        }

        if (designation.getText().toString().trim().isEmpty()){
            designation.setError("First Name cant be Empty");
            return false;
        }

        if (cityEditText.getText().toString().trim().isEmpty()){
            cityEditText.setError("City Name cant be Empty");
            return false;
        }

        return true;
    }
}
