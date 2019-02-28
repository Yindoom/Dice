package com.example.dice;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RollList extends ListActivity {

    ArrayList<Integer> list;

    Adapter a;

    @Override
    public void onCreate(Bundle data) {
        super.onCreate(data);

        list = (ArrayList<Integer>) getIntent().getSerializableExtra("list");

        a = new Adapter(this, R.layout.cell, list);
        this.setListAdapter(a);
    }
}
