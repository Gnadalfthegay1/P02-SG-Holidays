package com.myapplicationdev.android.p02sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<String> typeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lvTypes);
        typeList = new ArrayList<String>();
        typeList.add("Secular");
        typeList.add("Ethnic & Religion");
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, typeList);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ListActivity.class);
                i.putExtra("type", typeList.get(position));
                startActivity(i);
            }
        });
    }
}
