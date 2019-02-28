package com.example.dice;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {


    ArrayList<Integer> list;
    private int[] colours = {
            Color.WHITE,
            Color.LTGRAY
    };

    Context con;
    public Adapter(Context context, int textViewResourceId,
                       ArrayList<Integer> list) {
        super(context, textViewResourceId, list);

        con = context;
        this.list = list;
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


        int f = list.get(position);
        v.setBackgroundColor(colours[position % colours.length]);

        TextView roll = (TextView) v.findViewById(R.id.roll);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout);

        roll.setText("" + f);

        return v;
    }

}
