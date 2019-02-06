package com.example.dice;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout can1;
    LinearLayout can2;
    LinearLayout his;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        can1 = this.findViewById(R.id.canvas1);
        can2 = this.findViewById(R.id.canvas2);
        his = this.findViewById(R.id.history);
    }

    public void rollDie(android.view.View view){
        Random rand = new Random();
        int die1 = rand.nextInt(6)+1;
        int die2 = rand.nextInt(6)+1;
        can1.removeAllViews();
        can2.removeAllViews();
        drawDie(die1, can1);
        drawDie(die2, can2);
    }

    private void drawDie(int die, LinearLayout view) {
        View draw = new DrawView(this, die);
        view.addView(draw, 100, 100);
        TextView txt = new TextView(this);
        txt.setText(""+die);
        his.addView(txt);
    }
}
