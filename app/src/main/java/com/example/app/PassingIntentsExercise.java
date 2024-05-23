package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PassingIntentsExercise extends AppCompatActivity {

    EditText tFname, tLname, tDate, tPhone, tMail, tGuard, tSchool, tHob, tAge;
    RadioButton radMale, radFmale, radOthers;
    RadioGroup radioGroup;
    Button bttnClear, bttnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        tFname = findViewById(R.id.txtFirstName);
        tLname = findViewById(R.id.txtLastName);
        tDate = findViewById(R.id.txtFillDate);
        tPhone = findViewById(R.id.txtFillNumber);
        tMail = findViewById(R.id.txtFillMail);
        tGuard = findViewById(R.id.txtFillGuardianName);
        tSchool = findViewById(R.id.txtFillPSchool);
        tHob = findViewById(R.id.txtFillHobbies);
        tAge = findViewById(R.id.txtFillAge);

        radFmale = findViewById(R.id.radFmale);
        radMale = findViewById(R.id.radMale);
        radOthers = findViewById(R.id.radOthers);
        radioGroup = findViewById(R.id.radioGroup);

        bttnSubmit = findViewById(R.id.subBttn);
        bttnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = tFname.getText().toString();
                String lName = tLname.getText().toString();

                if (fName.isEmpty() || lName.isEmpty()) {
                    Toast.makeText(PassingIntentsExercise.this, "Please fill out the field!", Toast.LENGTH_SHORT).show();
                } else {
                    String gender;
                    if (radMale.isChecked()) {
                        gender = "Male";
                    } else if (radFmale.isChecked()) {
                        gender = "Female";
                    } else if (radOthers.isChecked()) {
                        gender = "Others";
                    } else {
                        gender = "Unknown";
                    }

                    String bDate = tDate.getText().toString();
                    String pNum = tPhone.getText().toString();
                    String eMail = tMail.getText().toString();
                    String guard = tGuard.getText().toString();
                    String hob = tHob.getText().toString();
                    String school = tSchool.getText().toString();
                    String age = tAge.getText().toString();

                    Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                    intent.putExtra("fname_key", fName);
                    intent.putExtra("gender_key", gender);
                    intent.putExtra("lname_key", lName);
                    intent.putExtra("phone_key", pNum);
                    intent.putExtra("bdate_key", bDate);
                    intent.putExtra("email_key", eMail);
                    intent.putExtra("guardian_key", guard);
                    intent.putExtra("hob_key", hob);
                    intent.putExtra("school_key", school);
                    intent.putExtra("age_key", age);

                    startActivity(intent);
                }
            }
        });

        bttnClear = findViewById(R.id.clrBttn);
        bttnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tFname.setText("");
                tLname.setText("");
                tDate.setText("");
                tPhone.setText("");
                tMail.setText("");
                tGuard.setText("");
                tSchool.setText("");
                tHob.setText("");
                tAge.setText("");
                radioGroup.clearCheck();
            }
        });
    }
}
