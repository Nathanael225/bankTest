package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate {
    public static Date date(String dateString) throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(dateString);
        return date;
    }
}
