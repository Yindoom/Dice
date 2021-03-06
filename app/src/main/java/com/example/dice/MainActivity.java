package com.example.dice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout can;
    NumberPicker amount;
    NumberPicker sides;
    ArrayList<ArrayList<Integer>> rolls;
    ArrayList<Date> timestamps;
    Button clear;
    Button roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timestamps = new ArrayList<>();
        rolls = new ArrayList<>();
        can = this.findViewById(R.id.canvas);
        amount = this.findViewById(R.id.amount);
        amount.setMinValue(1);
        amount.setMaxValue(6);
        sides = this.findViewById(R.id.sides);
        sides.setMaxValue(20);
        sides.setMinValue(3);
        sides.setVisibility(View.GONE);
        clear = this.findViewById(R.id.clear);

        roll = this.findViewById(R.id.roll);

        clear.setText("Clear");
        roll.setText("Roll");

    }

    public void rollDie(android.view.View view){
        can.removeAllViews();
        Random rand = new Random();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < amount.getValue(); i++) {
            int dieRoll = rand.nextInt(/*sides.getValue()*/ 6)+1;
            x.add(dieRoll);
            drawDie(dieRoll);
        }
        rolls.add(x);
        timestamps.add(Calendar.getInstance().getTime());
    }

    private void drawDie(int die) {
        View draw = new DrawView(this, die);
        can.addView(draw, 100, 100);
    }

    public void clear(android.view.View view) {
        can.removeAllViews();
    }

    public void goToRolls(View view) {
        Intent x = new Intent(this, RollList.class);
        x.putExtra("rolls", rolls);
        x.putExtra("timestamps", timestamps);
        startActivity(x);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
