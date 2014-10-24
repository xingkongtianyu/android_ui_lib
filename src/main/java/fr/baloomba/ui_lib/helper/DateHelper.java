package fr.baloomba.ui_lib.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static Date fromUS(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        return inputFormat.parse(dateString);
    }

    public static Date fromFR(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        return inputFormat.parse(dateString);
    }

    public static String toFR(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        return outputFormat.format(date);
    }

    public static String toUS(Date date) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
        return outputFormat.format(date);
    }

}
