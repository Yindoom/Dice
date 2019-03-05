package com.example.dice;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Adapter extends ArrayAdapter {


    SimpleDateFormat sdf;
    ArrayList<ArrayList<Integer>> rolls;
    ArrayList<Date> timestamps;
    private int[] colours = {
            Color.WHITE,
            Color.LTGRAY
    };

    Context con;
    public Adapter(Context context, int textViewResourceId,
                   ArrayList<ArrayList<Integer>> rolls, ArrayList<Date> timestamps) {
        super(context, textViewResourceId, rolls);

        sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        con = context;
        this.rolls = rolls;
        this.timestamps = timestamps;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.cell, null);
            Log.d("LIST", "Position: " + position + " View created");
        }
        else
            Log.d("LIST", "Position: " + position + " View Reused");



        String f = sdf.format(timestamps.get(position));
        ArrayList<Integer> x = rolls.get(position);

        TextView time = (TextView) v.findViewById(R.id.time);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout);
        ImageView poop = v.findViewById(R.id.test);

        for (int i = 0; i < x.size(); i++) {
            View die = new DrawView(con, x.get(i));
            layout.addView(die, 100, 100);
        }
        v.setBackgroundColor(colours[position % colours.length]);


        time.setText(f);

        return v;
    }

}
