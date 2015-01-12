package fr.baloomba.ui_lib.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    
    private static final String TAG = DateHelper.class.getSimpleName();

    public static final String DATE_FORMAT_MM_dd_yyyy = "MM/dd/yyyy";
    public static final String DATE_FORMAT_dd_MM_yyyy = "dd/MM/yyyy";
    
    public static final String DATE_FORMAT_dd_MM_yy = "dd/MM/yy";
    public static final String DATE_FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
    
    // <editor-fold desc="DEFAULT">
    
    public static Date fromString(String dateString, String format) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat(format);
        return inputFormat.parse(dateString);
    }

//    public static Date fromString(String dateString, String format) {
//        SimpleDateFormat inputFormat = new SimpleDateFormat(format);
//        try {
//            return inputFormat.parse(dateString);
//        } catch (ParseException e) {
//            Log.e(TAG, e.getMessage());
//        }
//        return null;
//    }
    
    public static String toString(Date date, String format) {
        SimpleDateFormat outputFormat = new SimpleDateFormat(format);
        return outputFormat.format(date);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="FR">

    public static Date fromStringFR(String dateString) throws ParseException {
        return fromString(dateString, DATE_FORMAT_dd_MM_yyyy);
    }

    public static String toStringFR(Date date) {
        return toString(date, DATE_FORMAT_dd_MM_yyyy);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="US">

    public static Date fromStringUS(String dateString) throws ParseException {
        return fromString(dateString, DATE_FORMAT_MM_dd_yyyy);
    }

    public static String toStringUS(Date date) {
        return toString(date, DATE_FORMAT_MM_dd_yyyy);
    }
    
    // </editor-fold>
    
    // <editor-fold desc="SETTERS">

    public static Date setHour(Date date, int hours) {
        return setTime(date, hours, -1, -1, -1);
    }

    public static Date setMinute(Date date, int minutes) {
        return setTime(date, -1, minutes, -1, -1);
    }

    public static Date setTime(Date date, int hours, int minutes) {
        return setTime(date, hours, minutes, -1, -1);
    }

    public static Date setTime(Date date, int hours, int minutes, int seconds) {
        return setTime(date, hours, minutes, seconds, -1);
    }
    
    public static Date setTime(Date date, int hour, int minute, int second, int millisecond) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour >= 0 ? hour : c.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, minute >= 0 ? minute : c.get(Calendar.MINUTE));
        c.set(Calendar.SECOND, second >= 0 ? second : c.get(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, millisecond >= 0 ? millisecond : c.get(Calendar.MILLISECOND));
        return c.getTime();
    }
    
    // </editor-fold>

}
