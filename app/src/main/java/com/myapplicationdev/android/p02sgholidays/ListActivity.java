package com.myapplicationdev.android.p02sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView lv;
    TextView tvType;
    ArrayList<Holiday> H;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        tvType = findViewById(R.id.tvType);
        lv = findViewById(R.id.lvHoliday);
        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tvType.setText(type);
        H = new ArrayList<Holiday>();
        if(type.equals("Secular")){
            H.add(new Holiday("New Year's Day", "1 January 2020", true));
            H.add(new Holiday("Labour Day", "1 May 2020", true));
        }
        else{
            H.add(new Holiday("Chinese New Year", "25 January 2020", false));
            H.add(new Holiday("Good Friday", "10 April 2020", false));
        }

        aa = new HolidayAdapter(this, R.layout.row, H);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday H1 = H.get(position);
                Toast.makeText(getApplicationContext(), H1.getName()
                                + " Date: " + H1.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
