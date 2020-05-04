package com.myapplicationdev.android.p02sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> H;
    private Context context;
    private TextView tvName, tvDate;
    private ImageView ivHoliday;


    public HolidayAdapter(@NonNull Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);

        H = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName= (TextView) rowView.findViewById(R.id.tvName);
        tvDate= (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = H.get(position);
        // Set the TextView to show the food

        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if(currentHoliday.isSecular()) {
            if(currentHoliday.getName() == "New Year's Day") {
                ivHoliday.setImageResource(R.drawable.hny);
            }
            else{
                ivHoliday.setImageResource(R.drawable.ld);
            }
        }
        else {
            if(currentHoliday.getName() == "Chinese New Year") {
                ivHoliday.setImageResource(R.drawable.cny);
            }
            else{
                ivHoliday.setImageResource(R.drawable.gf);
            }
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

    }
