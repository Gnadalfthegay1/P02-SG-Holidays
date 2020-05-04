package com.myapplicationdev.android.p02sgholidays;

public class Holiday {
    private String name, date;
    private boolean secular;

    public Holiday(String name, String date, boolean secular) {
        this.name = name;
        this.date = date;
        this.secular = secular;
    }

    public String getName() {
        return name;
    }



    public String getDate() {
        return date;
    }

    public boolean isSecular() {
        return secular;
    }
}
