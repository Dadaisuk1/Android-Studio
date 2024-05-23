package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    private TextView numCalculate, numResult;
    Button bttnZero, bttn1, bttn2, bttn3, bttn4, bttn5, bttn6, bttn7, bttn8, bttn9, bttnDiv, bttnMul, bttnDiff, bttnEqual, bttnAdd, bttnPoint, bttnClear, bttnDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numCalculate = findViewById(R.id.numCalculate);
        numResult = findViewById(R.id.numResult);

        bttnZero = findViewById(R.id.bttn0);
        bttn1 = findViewById(R.id.bttn1);
        bttn2 = findViewById(R.id.bttn2);
        bttn3 = findViewById(R.id.bttn3);
        bttn4 = findViewById(R.id.bttn4);
        bttn5 = findViewById(R.id.bttn5);
        bttn6 = findViewById(R.id.bttn6);
        bttn7 = findViewById(R.id.bttn7);
        bttn8 = findViewById(R.id.bttn8);
        bttn9 = findViewById(R.id.bttn9);
        bttnMul = findViewById(R.id.bttnMul);
        bttnDiv = findViewById(R.id.bttnDiv);
        bttnDiff = findViewById(R.id.bttnDiff);
        bttnEqual = findViewById(R.id.bttnEqual);
        bttnAdd = findViewById(R.id.bttnAdd);
        bttnPoint = findViewById(R.id.bttnPoint);
        bttnClear = findViewById(R.id.bttnDel);
        bttnDel = findViewById(R.id.bttnDel);

        bttnZero.setOnClickListener(this);
        bttn1.setOnClickListener(this);
        bttn2.setOnClickListener(this);
        bttn3.setOnClickListener(this);
        bttn4.setOnClickListener(this);
        bttn5.setOnClickListener(this);
        bttn6.setOnClickListener(this);
        bttn7.setOnClickListener(this);
        bttn8.setOnClickListener(this);
        bttn9.setOnClickListener(this);
        bttnDiv.setOnClickListener(this);
        bttnMul.setOnClickListener(this);
        bttnDiff.setOnClickListener(this);
        bttnEqual.setOnClickListener(this);
        bttnAdd.setOnClickListener(this);
        bttnPoint.setOnClickListener(this);
        bttnClear.setOnClickListener(this);
        bttnDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();
        String data = numCalculate.getText().toString();

        switch (buttonText) {
            case "C":
                numCalculate.setText("");
                numResult.setText("");
                break;

            case "Del":
                try {
                    data = data.substring(0, data.length() - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                    numResult.setText("0");
                } finally {
                    numCalculate.setText(data);
                }
                break;

            case "=":
                try {
                    if (endsWith(data)) {
                        numResult.setText("Syntax Error");
                    } else {
                        data = calculateData(data);
                        numResult.setText(data);
                        numCalculate.setText("0");
                    }
                } catch(Exception e) {
                    numResult.setText("");
                }
                break;
            case ".":
                String last_num = "";
                for(int i = data.length()-1; i>=0; i--){
                    if(isOperator(data.charAt(i))){
                        break;
                    }
                    last_num += data.charAt(i);
                }
                if(last_num.equals("")){
                    data += "0";
                    data += buttonText;
                } else if(last_num.contains(".")){
                    if(last_num.charAt(0) == '.'){
                        data = data.substring(0,data.length() - 1);
                    }
                } else {
                    data += buttonText;
                }
                numCalculate.setText(data);
                break;

            default:
                if (!data.isEmpty() && isOperator(data.charAt(data.length() - 1)) && isOperator(buttonText)) {
                    data = data.substring(0, data.length() - 1);
                }
                String tempo = data;
                data += buttonText;
                if(isOperator(buttonText)){
                    numCalculate.setText(data);
                } else {
                    numCalculate.setText(tempo + buttonText);
                }
                if(isOperator(buttonText)){
                    numResult.setText(sequentialCalculate(tempo));
                }
                break;
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷';
    }
    private boolean endsWith(String expression) {
        char lastChar = expression.charAt(expression.length() - 1);
        return lastChar == '+' || lastChar == '-' || lastChar == '×' || lastChar == '÷';

    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("×")||s.equals("÷");
    }
    private String calculateData(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        // Tokenize the expression into numbers and operators
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }

        Stack<String> stackOp = new Stack<>();
        Stack<Double> stackNum = new Stack<>();

        for (String token : finalData) {
            if (isOperator(token)) {
                while (!stackOp.isEmpty() && precedence(token) <= precedence(stackOp.peek())) {
                    processOperator(stackOp.pop(), stackNum);
                }
                stackOp.push(token);
            } else {
                stackNum.push(Double.parseDouble(token));
            }
        }

        while (!stackOp.isEmpty()) {
            processOperator(stackOp.pop(), stackNum);
        }

        return String.valueOf(stackNum.pop());
    }

    private int precedence(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if (op.equals("×") || op.equals("÷")) {
            return 2;
        }
        return 0;
    }

    private void processOperator(String op, Stack<Double> stackNum) {
        double num2 = stackNum.pop();
        double num1 = stackNum.pop();

        switch (op) {
            case "+":
                stackNum.push(num1 + num2);
                break;
            case "-":
                stackNum.push(num1 - num2);
                break;
            case "×":
                stackNum.push(num1 * num2);
                break;
            case "÷":
                stackNum.push(num1 / num2);
                break;
        }
    }

    private String sequentialCalculate(String data){
        ArrayList<String> finalData = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }

        Stack<String> stackOp = new Stack<>();
        int start = 0;

        if(isOperator(finalData.get(0))){
            stackOp.push("0");
        } else {
            stackOp.push(finalData.get(0));
            start = 1;
        }

        for (int i = start; i < finalData.size(); i++) {
            if ( isOperator(finalData.get(i))) {
                if(finalData.get(i).equals("+")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum + nextNum));
                } else if (finalData.get(i).equals("-")){
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum - nextNum));
                } else if (finalData.get(i).equals("×")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum * nextNum));
                } else if (finalData.get(i).equals("÷")) {
                    double prevNum = Double.parseDouble(stackOp.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    stackOp.push(String.valueOf(prevNum / nextNum));
                }
            } else {
                stackOp.push(finalData.get(i));
            }
        }
        return stackOp.pop();
    }
    
}