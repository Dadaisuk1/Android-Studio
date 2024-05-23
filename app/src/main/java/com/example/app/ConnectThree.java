package com.example.app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ConnectThree extends AppCompatActivity {
    boolean player=true;
    int[] playerColor = {Color.rgb(255, 20, 20), Color.rgb(255, 232, 32)};
    ArrayList <Button> boardGame;
    int[][] checking = {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0}};
    private Button bttnReset;
    private TextView txtAnnounce, txtTurn;
    int[] col1 = {0, 0, 0, 0, 0};
    int[] col2 = {0, 0, 0, 0, 0};
    int[] col3 = {0, 0, 0, 0, 0};
    int[] col4 = {0, 0, 0, 0, 0};
    int[] col5 = {0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(ConnectThree.this, "Darwin Darryl Jean Largoza", Toast.LENGTH_SHORT).show();
        Toast.makeText(ConnectThree.this, "Welcome To Connect 3 Game!",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connect_three);

        boardGame = new ArrayList<>();
        txtAnnounce = findViewById(R.id.txtAnnounce);
        txtTurn = findViewById(R.id.txtTurn);
        txtTurn.setTextSize(30);
        txtAnnounce.setTextSize(60);
        /*txtAnnounce.setTextColor(Color.rgb(3,18, 86));*/

        /*First Column*/
        Button bttn1 = findViewById(R.id.bttn1);
        Button bttn2 = findViewById(R.id.bttn2);
        Button bttn3 = findViewById(R.id.bttn3);
        Button bttn4 = findViewById(R.id.bttn4);
        Button bttn5 = findViewById(R.id.bttn5);

        ArrayList<Button> bttnOne = new ArrayList<>();
        bttnOne.add((Button) bttn1.findViewById(R.id.bttn1));
        bttnOne.add((Button) bttn2.findViewById(R.id.bttn2));
        bttnOne.add((Button) bttn3.findViewById(R.id.bttn3));
        bttnOne.add((Button) bttn4.findViewById(R.id.bttn4));
        bttnOne.add((Button) bttn5.findViewById(R.id.bttn5));

        bttnOne.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = !player;

                startAct(bttnOne,col1,0);
            }
        });

        /*Second Column*/
        Button bttn6 = findViewById(R.id.bttn6);
        Button bttn7 = findViewById(R.id.bttn7);
        Button bttn8 = findViewById(R.id.bttn8);
        Button bttn9 = findViewById(R.id.bttn9);
        Button bttn10 = findViewById(R.id.bttn10);

        ArrayList<Button> bttnTwo = new ArrayList<>();
        bttnTwo.add((Button) bttn6.findViewById(R.id.bttn6));
        bttnTwo.add((Button) bttn7.findViewById(R.id.bttn7));
        bttnTwo.add((Button) bttn8.findViewById(R.id.bttn8));
        bttnTwo.add((Button) bttn9.findViewById(R.id.bttn9));
        bttnTwo.add((Button) bttn10.findViewById(R.id.bttn10));

        bttnTwo.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = !player;

                startAct(bttnTwo,col2,1);
            }
        });

        /*Third Column*/
        Button bttn11 = findViewById(R.id.bttn11);
        Button bttn12 = findViewById(R.id.bttn12);
        Button bttn13 = findViewById(R.id.bttn13);
        Button bttn14 = findViewById(R.id.bttn14);
        Button bttn15 = findViewById(R.id.bttn15);

        ArrayList<Button> bttnThree = new ArrayList<>();
        bttnThree.add((Button) bttn11.findViewById(R.id.bttn11));
        bttnThree.add((Button) bttn12.findViewById(R.id.bttn12));
        bttnThree.add((Button) bttn13.findViewById(R.id.bttn13));
        bttnThree.add((Button) bttn14.findViewById(R.id.bttn14));
        bttnThree.add((Button) bttn15.findViewById(R.id.bttn15));

        bttnThree.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = !player;

                startAct(bttnThree,col3,2);
            }
        });

        /*Fourth Column*/
        Button bttn16 = findViewById(R.id.bttn16);
        Button bttn17 = findViewById(R.id.bttn17);
        Button bttn18 = findViewById(R.id.bttn18);
        Button bttn19 = findViewById(R.id.bttn19);
        Button bttn20 = findViewById(R.id.bttn20);

        ArrayList<Button> bttnFour = new ArrayList<>();
        bttnFour.add((Button) bttn16.findViewById(R.id.bttn16));
        bttnFour.add((Button) bttn17.findViewById(R.id.bttn17));
        bttnFour.add((Button) bttn18.findViewById(R.id.bttn18));
        bttnFour.add((Button) bttn19.findViewById(R.id.bttn19));
        bttnFour.add((Button) bttn20.findViewById(R.id.bttn20));

        bttnFour.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = !player;

                startAct(bttnFour,col4,3);
            }
        });

        /*Fifth Column*/
        Button bttn21 = findViewById(R.id.bttn21);
        Button bttn22 = findViewById(R.id.bttn22);
        Button bttn23 = findViewById(R.id.bttn23);
        Button bttn24 = findViewById(R.id.bttn24);
        Button bttn25 = findViewById(R.id.bttn25);

        ArrayList<Button> bttnFive = new ArrayList<>();
        bttnFive.add((Button) bttn21.findViewById(R.id.bttn21));
        bttnFive.add((Button) bttn22.findViewById(R.id.bttn22));
        bttnFive.add((Button) bttn23.findViewById(R.id.bttn23));
        bttnFive.add((Button) bttn24.findViewById(R.id.bttn24));
        bttnFive.add((Button) bttn25.findViewById(R.id.bttn25));

        bttnFive.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = !player;

                startAct(bttnFive,col5,4);
            }
        });

        boardGame.addAll(bttnOne);
        boardGame.addAll(bttnTwo);
        boardGame.addAll(bttnThree);
        boardGame.addAll(bttnFour);
        boardGame.addAll(bttnFive);

        bttnReset = findViewById(R.id.bttnReset);
        bttnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConnectThree.this, "Reset", Toast.LENGTH_LONG).show();
                reset();
            }
        });

    }


    /*Starting*/
    void startAct(ArrayList<Button> start, int[]row, int col){
        int color;
        int num;
        if(player){
            color = playerColor[0];
            num = 1;
        } else {
            color = playerColor[1];
            num = 2;
        }

        for(int i=4;i>=0;i--){
            if(row[i]==0){
                start.get(i).setBackgroundColor(color);
                row[i] = 1;
                checking[i][col] = num;
                checker();
                return;
            }
        }
        return;
    }

    /*Checker*/
    void checker() {
        colChecker();
        rowChecker();
        leftDiagonalChecker();
        rightDiagonalChecker();
        if (txtTurn.isEnabled()) {
            if (player) {
                txtTurn.setText("Yellow's Turn");
                txtTurn.setTextColor(Color.rgb(255, 232, 32));
            } else {
                txtTurn.setText("Red's Turn");
                txtTurn.setTextColor(Color.rgb(255, 20, 20));
            }
        }
    }

    /*Left Diagonal Checker*/
    void leftDiagonalChecker(){
        for (int i = 0; i < checking.length - 2; i++) {
            for (int j = 2; j < checking[i].length; j++) {
                if (checking[i][j] != 0 && checking[i][j] == checking[i + 1][j - 1] && checking[i][j] == checking[i + 2][j - 2]) {
                    disable(boardGame);
                    if(checking[i][j]==1){
                        txtAnnounce.setText("Winner Red!");
                        txtAnnounce.setTextColor(Color.rgb(255, 20, 20));
                        return;
                    }
                    txtAnnounce.setText("Winner Yellow!");
                    txtAnnounce.setTextColor(Color.rgb(255, 232, 32));
                    return;
                }
            }
        }
    }

    /*Diagonal Checker*/
    void rightDiagonalChecker(){
        for (int i = 0; i < 5 - 2; i++) {
            for (int j = 0; j < 5 - 2; j++) {
                if (checking[i][j] != 0 && checking[i][j] == checking[i + 1][j + 1] && checking[i][j] == checking[i + 2][j + 2]) {
                    disable(boardGame);
                    if(checking[i][j]==1){
                        txtAnnounce.setText("Winner Red!");
                        txtAnnounce.setTextColor(Color.rgb(255, 20, 20));
                        return;
                    }
                    txtAnnounce.setText("Winner Yellow!");
                    txtAnnounce.setTextColor(Color.rgb(255, 232, 32));
                    return;
                }
            }
        }
    }

    /*Column Checker*/
    void colChecker() {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5- 2; i++) {
                if (checking[i][j] != 0 && checking[i][j] == checking[i + 1][j] && checking[i][j] == checking[i + 2][j]) {
                    disable(boardGame);
                    if(checking[i][j]==1){
                        txtAnnounce.setText("Winner Red!");
                        txtAnnounce.setTextColor(Color.rgb(255, 20, 20));
                        return;
                    }
                    txtAnnounce.setText("Winner Yellow!");
                    txtAnnounce.setTextColor(Color.rgb(255, 232, 32));
                    return;
                }
            }
        }
    }

    /*Row Checker*/
    void rowChecker(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - 2; j++) {
                if (checking[i][j] != 0 && checking[i][j] == checking[i][j + 1] && checking[i][j] == checking[i][j + 2]) {
                    disable(boardGame);
                    if(checking[i][j]==1){
                        txtAnnounce.setText("Winner Red!");
                        txtAnnounce.setTextColor(Color.rgb(255, 20, 20));
                        return;
                    }
                    txtAnnounce.setText("Winner Yellow!");
                    txtAnnounce.setTextColor(Color.rgb(255, 232, 32));
                    return;
                }
            }
        }
    }

    /*Disabled*/
    void disable(ArrayList<Button> boardGame) {
        for(Button resets : boardGame) {
            resets.setEnabled(false);
        }
        txtTurn.setEnabled(false);
    }

    /*Initialization Color*/
    void initializeColor() {
        txtTurn.setText("Yellow's Turn");
        txtTurn.setTextColor(Color.rgb(255, 232, 32));
        txtAnnounce.setText("");
        for (Button resets : boardGame) {
            resets.setBackgroundColor(Color.rgb(3, 18, 86));
        }
    }

    /*Reset*/
    void reset() {
        for(Button resets : boardGame){
            resets.setEnabled(true);
        }
        initializeColor();
        txtTurn.setEnabled(true);
        checking = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        player = true;
        col1 = new int[]{0, 0, 0, 0, 0};
        col2 = new int[]{0, 0, 0, 0, 0};
        col3 = new int[]{0, 0, 0, 0, 0};
        col4 = new int[]{0, 0, 0, 0, 0};
        col5 = new int[]{0, 0, 0, 0, 0};
    }
}