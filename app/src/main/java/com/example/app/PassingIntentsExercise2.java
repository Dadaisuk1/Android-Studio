package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tFname, tLname, tGender, tDate, tPhone, tMail, tGuard, tHob, tSchool, tAge;
    Button bttnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        tFname = findViewById(R.id.labelFirstName);
        tLname = findViewById(R.id.labelLastName);
        tDate = findViewById(R.id.labelBirthDate);
        tPhone = findViewById(R.id.labelPhoneNumber);
        tMail = findViewById(R.id.labelEmailAddress);
        tGender = findViewById(R.id.labelGender);
        tGuard = findViewById(R.id.labelGuardian);
        tHob = findViewById(R.id.labelHobbies);
        tSchool = findViewById(R.id.labelSchool);
        tAge = findViewById(R.id.labelAge);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String bdate = intent.getStringExtra("bdate_key");
        String gender = intent.getStringExtra("gender_key");
        String phone = intent.getStringExtra("phone_key");
        String email = intent.getStringExtra("email_key");
        String guard = intent.getStringExtra("guardian_key");
        String hob = intent.getStringExtra("hob_key");
        String school = intent.getStringExtra("school_key");
        String age = intent.getStringExtra("age_key");

        tFname.setText(fname);
        tGender.setText(gender);
        tLname.setText(lname);
        tMail.setText(email);
        tDate.setText(bdate);
        tPhone.setText(phone);
        tGuard.setText(guard);
        tHob.setText(hob);
        tSchool.setText(school);
        tAge.setText(age);

        bttnReturn = findViewById(R.id.bttnReturn);
        bttnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
