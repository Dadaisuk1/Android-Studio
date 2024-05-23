package com.example.app;

import static android.graphics.Color.parseColor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuExercise extends AppCompatActivity {
    Button bttnChanger;
    ImageView menuIcon;
    int resetCountClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_exercise);

        bttnChanger = findViewById(R.id.bttnTrans);
        bttnChanger.setClickable(false);

        bttnChanger.setText("");
        bttnChanger.setTextColor(Color.parseColor("#FFFFFF"));
        bttnChanger.setBackgroundColor(Color.parseColor("#FF673AB7"));
        bttnChanger.setVisibility(View.VISIBLE);

        menuIcon = findViewById(R.id.menuIcon);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, menuIcon);
        popupMenu.getMenuInflater().inflate(R.menu.menu_exercise, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_exercise, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mChangeItem) {
            Toast.makeText(this, "Change Items!", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.mWord) {
            bttnChanger.setText("I love you!\n<3");
            Toast.makeText(this, "Kilig!", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.mTxtColor) {
            bttnChanger.setTextColor(parseColor("#FFFF00"));

        } else if (item.getItemId() == R.id.mBGColor) {
            bttnChanger.setBackgroundColor(parseColor("#FFFF0000"));

        } else if (item.getItemId() == R.id.mSize) {
            ViewGroup.LayoutParams params = bttnChanger.getLayoutParams();
            params.height = 200;
            bttnChanger.setLayoutParams(params);

        } else if (item.getItemId() == R.id.mInvisible){
            bttnChanger.setVisibility(View.INVISIBLE);

        } else if (item.getItemId() == R.id.mReset) {
            bttnChanger.setText("");
            bttnChanger.setTextColor(Color.parseColor("#FFFFFF"));
            bttnChanger.setBackgroundColor(Color.parseColor("#FF673AB7"));
            ViewGroup.LayoutParams params = bttnChanger.getLayoutParams();
            params.height = 440;
            params.width = 440;
            bttnChanger.setLayoutParams(params);
            bttnChanger.setVisibility(View.VISIBLE);

        } else if (item.getItemId() == R.id.mExit) {
            finish();
        }
        return true;
    }
}