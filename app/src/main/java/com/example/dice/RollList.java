package com.example.dice;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class RollList extends ListActivity {

    ArrayList<ArrayList<Integer>> rolls;
    ArrayList<Date> timestamps;

    Adapter a;

    @Override
    public void onCreate(Bundle data) {
        super.onCreate(data);

        rolls = (ArrayList<ArrayList<Integer>>) getIntent().getSerializableExtra("rolls");
        timestamps = (ArrayList<Date>) getIntent().getSerializableExtra("timestamps");

        a = new Adapter(this, R.layout.cell, rolls, timestamps);
        this.setListAdapter(a);
    }
}
