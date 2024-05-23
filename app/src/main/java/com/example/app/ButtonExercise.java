package com.example.app;

import static com.example.app.R.color.Dark_Blue;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.protobuf.Empty;

public class ButtonExercise extends AppCompatActivity {

    private Button closeBttn, toastBttn, bgBttn, bttnBg, invBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_exercise);

        closeBttn = findViewById(R.id.closeBttn);
        closeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });

        toastBttn = findViewById(R.id.toastBttn);
        toastBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonExercise.this, "Toasted!", Toast.LENGTH_SHORT).show();
            }
        });

        bgBttn = findViewById(R.id.bgBttn);
        bgBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((View)findViewById(R.id.main)).setBackgroundColor(Color.parseColor("#031256"));
            }
        });

        bttnBg = findViewById(R.id.bttnBg);
        bttnBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bttnBg.setBackgroundColor(Color.rgb(12,32,5));
            }
        });

        invBttn = findViewById(R.id.invBttn);
        invBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invBttn.setVisibility(View.INVISIBLE);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}