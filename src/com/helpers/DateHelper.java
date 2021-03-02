package com.helpers;

public class DateHelper {
    public static String format(String DateString) {
        String[] parts = DateString.split("-|/");
        if (parts[0].length() > 2)
            return "" + parts[0] + '-' + parts[1] + '-' + parts[2] + "";
        return "" + parts[2] + '-' + parts[1] + '-' + parts[0] + "";
    }
    
}
