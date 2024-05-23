package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button bttnInstagram, bttnExercise, bttnCalculator, bttnConnect, bttnPassIntents, bttnFrag, bttnMenu, bttnColorMatch, bttnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bttnInstagram = findViewById(R.id.bttnInstagram);
        bttnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInstagram();
                Toast.makeText(MainActivity.this, "One welcome you to Instagram!", Toast.LENGTH_LONG).show();
            }
        });

        bttnExercise = findViewById(R.id.bttnExercise);
        bttnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButtonExercise();
                Toast.makeText(MainActivity.this, "Buttons Exercise!", Toast.LENGTH_LONG).show();
            }
        });

        bttnCalculator = findViewById(R.id.bttnCalculator);
        bttnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculator();
                Toast.makeText(MainActivity.this, "Calculator", Toast.LENGTH_LONG).show();
            }
        });

        bttnConnect = findViewById(R.id.bttnConnect);
        bttnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConnect3();
            }
        });

        bttnPassIntents = findViewById(R.id.bttnPassIntents);
        bttnPassIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Fill up the form", Toast.LENGTH_SHORT).show();
                openPassIntent();
            }
        });

        bttnFrag = findViewById(R.id.bttnFrag);
        bttnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragments();
            }
        });

        bttnMenu = findViewById(R.id.bttnMenu);
        bttnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        bttnColorMatch = findViewById(R.id.bttnMidterm);
        bttnColorMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorMatch();
            }
        });

        bttnMap = findViewById(R.id.bttnMap);
        bttnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void openMenu() {
        Intent menu = new Intent(this, MenuExercise.class);
        startActivity(menu);
    }

    private void openFragments() {
        Intent fragments = new Intent(this, FragmentsExercise.class);
        startActivity(fragments);
    }

    private void openPassIntent() {
        Intent passIntent = new Intent(this, PassingIntentsExercise.class);
        startActivity(passIntent);
    }

    private void openActivityInstagram() {
        Intent insta = new Intent(this, Instagram.class);
        startActivity(insta);
    }

    private void openButtonExercise() {
        Intent bttnExer = new Intent(this, ButtonExercise.class);
        startActivity(bttnExer);
    }

    private void openCalculator() {
        Intent bttnCalcu = new Intent(this, Calculator.class);
        startActivity(bttnCalcu);
    }

    private void openConnect3() {
        Intent bttnConnect = new Intent(this, ConnectThree.class);
        startActivity(bttnConnect);
    }

    private void openColorMatch() {
        Intent bttnColor = new Intent(this, ColorMatch.class);
        startActivity(bttnColor);
    }

    private void openMap() {
        Intent map = new Intent(this, MapExercise.class);
        startActivity(map);
    }

}