package com.example.tristans.calculatrice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Button> buttons = new ArrayList<Button>();
        buttons.add((Button) findViewById(R.id.button0));
        buttons.add((Button) findViewById(R.id.button1));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
        buttons.add((Button) findViewById(R.id.button6));
        buttons.add((Button) findViewById(R.id.button7));
        buttons.add((Button) findViewById(R.id.button8));
        buttons.add((Button) findViewById(R.id.button9));

        buttons.add((Button) findViewById(R.id.buttonPlus));
        buttons.add((Button) findViewById(R.id.buttonMoins));
        buttons.add((Button) findViewById(R.id.buttonMultiplier));
        buttons.add((Button) findViewById(R.id.buttonDivision));

        buttons.add((Button) findViewById(R.id.buttonPoint));
        buttons.add((Button) findViewById(R.id.buttonC));
        buttons.add((Button) findViewById(R.id.buttonMoyenne));
        buttons.add((Button) findViewById(R.id.buttonAcc));
        buttons.add((Button) findViewById(R.id.buttonEgal));

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        text = (EditText) findViewById(R.id.EditText01);
        switch (v.getId()) {
            case R.id.buttonC:
                text.setText("");
                break;
            case R.id.button0:
                text.setText(text.getText() + "0");
                break;
            case R.id.button1:
                text.setText(text.getText() + "1");
                break;
            case R.id.button2:
                text.setText(text.getText() + "2");
                break;
            case R.id.button3:
                text.setText(text.getText() + "3");
                break;
            case R.id.button4:
                text.setText(text.getText() + "4");
                break;
            case R.id.button5:
                text.setText(text.getText() + "5");
                break;
            case R.id.button6:
                text.setText(text.getText() + "6");
                break;
            case R.id.button7:
                text.setText(text.getText() + "7");
                break;
            case R.id.button8:
                text.setText(text.getText() + "8");
                break;
            case R.id.button9:
                text.setText(text.getText() + "9");
                break;

            case R.id.buttonPlus:
                MustCompute(text.getText().toString());
                text.setText(text.getText() + "+");
                break;
            case R.id.buttonMoins:
                MustCompute(text.getText().toString());
                text.setText(text.getText() + "-");
                break;
            case R.id.buttonMultiplier:
                MustCompute(text.getText().toString());
                text.setText(text.getText() + "*");
                break;
            case R.id.buttonDivision:
                MustCompute(text.getText().toString());
                text.setText(text.getText() + "/");
                break;
            case R.id.buttonPoint:
                if(!text.getText().toString().contains((".")))
                    text.setText(text.getText() + ".");
                break;
            case R.id.buttonEgal:
                Compute(text.getText().toString());
                break;
        }
    }

    public void Compute(String calcul) {
        Log.d("Calc", "Calcul en cours");
        String[] parts;
        double result = 0;
        if (calcul.contains("+")) {
            parts = calcul.split("\\+");
            Log.d("Calc - part0", parts[0]);
            Log.d("Calc - part1", parts[1]);
            result = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        }
        if (calcul.contains("-")) {
            parts = calcul.split("-");
            Log.d("Calc - part0", parts[0]);
            Log.d("Calc - part1", parts[1]);
            result = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        }
        if (calcul.contains("*")) {
            parts = calcul.split("\\*");
            Log.d("Calc - part0", parts[0]);
            Log.d("Calc - part1", parts[1]);
            result = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        }
        if (calcul.contains("/")) {
            parts = calcul.split("\\/");
            Log.d("Calc - part0", parts[0]);
            Log.d("Calc - part1", parts[1]);
            result = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        }
        text.setText(Double.toString(result));
    }

    public void MustCompute(String actualString) {
        Log.d("Calc", "Dois-je calculer ?");
        Log.d("Calc",actualString.toString());
        if(actualString.contains("+") || actualString.contains("/") || actualString.contains("*") || actualString.contains("-")){
            Compute(actualString);
        }
    }
}
