package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Double firstVar;
    private Double secondVar;
    private Boolean isOperationClick;
    private String operation;
    private MaterialButton btnNotAnInteger;
    private MaterialButton btnEqual;
    private MaterialButton btnInvisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEqual=findViewById(R.id.rovno);
        btnInvisible=findViewById(R.id.clear_text);
        btnInvisible.setOnClickListener(view -> {
            String result = String.valueOf(tvResult.getText());
            Intent intent = new Intent(MainActivity.this,MainActivityPolicies.class);
            intent.putExtra("key1",result);
            startActivity(intent);
        });
        tvResult = findViewById(R.id.rovno);

        btnEqual.setOnClickListener(view -> {
            if(btnInvisible.getAlpha()==0){
                btnInvisible.animate().alpha(1);
            }else {
                onOperationClick(view);
            }

        });
    }


    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.numberOfZero:
                setNumber("0");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfOne:
                setNumber("1");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfTwo:
                setNumber("2");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfThree:
                setNumber("3");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfFour:
                setNumber("4");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfFive:
                setNumber("5");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfSix:
                setNumber("6");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfSeven:
                setNumber("7");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfEight:
                setNumber("8");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.numberOfNine:
                setNumber("9");
                btnInvisible.animate().alpha(0);
                break;
            case R.id.clear_text:
                tvResult.setText("0");
                firstVar = 0.0;
                secondVar = 0.0;
                btnInvisible.animate().alpha(0);
                break;



        }
    }

    private void setNumber(String number){
        btnNotAnInteger=findViewById(R.id.tochka);
        btnNotAnInteger.setOnClickListener(view -> {
            if(tvResult.getText().toString().equals("0")){
                tvResult.append(".");
            } else {
                tvResult.append(".");
            }
        });
        if (tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }
        else if (isOperationClick){
            tvResult.setText(number);

        }

        else{
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.plusAndMinus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "+/-";
                isOperationClick = true;
                break;
            case R.id.summa:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.minus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case R.id.delenie:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case R.id.ymnojenie:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                operation = "*";
                isOperationClick = true;
                break;

            case R.id.rovno:
                secondVar = Double.parseDouble(tvResult.getText().toString());
                Double result = 0.0;
                switch (operation ){
                    case "+/-":
                        result = firstVar+secondVar;
                    case "+":
                        result = firstVar + secondVar;
                        break;
                    case "-":
                        result = firstVar-secondVar;
                        break;
                    case "*":
                        result = firstVar*secondVar;
                        break;
                    case "/":
                        result = firstVar/secondVar;
                        break;

                }
                tvResult.setText(new DecimalFormat("##.#######").format(result));
                break;
        }
    }
}
