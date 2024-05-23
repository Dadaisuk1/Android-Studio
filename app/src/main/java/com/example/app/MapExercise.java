package com.example.app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MapExercise extends AppCompatActivity {

    ImageButton img1, img2, img3, img4, img5;
    LinearLayout bg;
    ConstraintLayout constraint;
    ArrayList <View> views;
    ArrayList <TextView> edittexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_exercise);
        constraint = (ConstraintLayout) findViewById(R.id.background);
        bg = findViewById(R.id.mainBg);
        views=new ArrayList<>();
        edittexts=new ArrayList<>();
        for(int i = 0; i < bg.getChildCount(); i++) {
            for(int j = 0 ; j < 2; j++){
                if(((LinearLayout) (bg.getChildAt(i))).getChildAt(j) instanceof TextView) {
                    edittexts.add((TextView) ((LinearLayout)(bg.getChildAt(i))).getChildAt(j));
                }
            }

        }

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 48.85847732996591, 2.294539396751854"));
                startActivity(img1);
                constraint.setBackground(getDrawable(R.drawable.eiffel_tower_sv_));
                toWhite();
            }
        });

        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img2 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 33.812596331803064, -117.91896664343102"));
                startActivity(img2);
                constraint.setBackground(getDrawable(R.drawable.disneyland_sv_));
                toWhite();
            }
        });

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent img3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 35.661946546410036, 139.74476617736008"));
                startActivity(img3);
                constraint.setBackground(getDrawable(R.drawable.tokyotower_sv_));
                toWhite();
            }
        });

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img4 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 41.89278136295029, 12.49113129074097"));
                startActivity(img4);
                constraint.setBackground(getDrawable(R.drawable.coloseum_sv_));
                toWhite();
            }
        });

        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent img5 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.28239256152389, 123.88080705590713"));
                startActivity(img5);
                constraint.setBackground(getDrawable(R.drawable.seaside_sv_));
                toWhite();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    void toWhite(){
        for (TextView et:
                edittexts) {
            et.setTextColor(Color.WHITE);

        }
    }
}