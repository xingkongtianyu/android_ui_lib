package fr.baloomba.ui_lib.helper;

import android.content.Context;

import fr.baloomba.ui_lib.R;

import java.util.Calendar;

public class CalendarHelper {

    public static long MINUTES = 60;
    public static long HOURS = 60 * MINUTES;
    public static long DAYS = 24 * HOURS;
    public static long WEEKS = 7 * DAYS;
    public static long MONTH = 30 * DAYS;
    public static long YEAR = 12 * MONTH;

    public static String getDate(Context context, Calendar calendar) {
        Calendar now = Calendar.getInstance();
        long diff = now.getTimeInMillis() / 1000 - calendar.getTimeInMillis() / 1000;
        diff = diff < 0 ? 0 : diff;
        long years = diff / YEAR;
        long months = diff / MONTH;
        long weeks = diff / WEEKS;
        long days = diff / DAYS;
        long hours = diff / HOURS;
        long minutes = diff / MINUTES;
        String time;
        if (years > 0)
            time = years + " " + ((years > 1) ? context.getString(R.string.Years) :
                    context.getString(R.string.Year));
        else if (months > 0)
            time = months + " " + ((months > 1) ? context.getString(R.string.Months) :
                    context.getString(R.string.Month));
        else if (weeks > 0)
            time = weeks + " " + ((weeks > 1) ? context.getString(R.string.Weeks) :
                    context.getString(R.string.Week));
        else if (days > 0)
            time = days + " " + ((days > 1) ? context.getString(R.string.Days) :
                    context.getString(R.string.Day));
        else if (hours > 0)
            time = hours + " " + ((hours > 1) ? context.getString(R.string.Hours) :
                    context.getString(R.string.Hour));
        else if (minutes > 0)
            time = minutes + " " + ((minutes > 1) ? context.getString(R.string.Minutes) :
                    context.getString(R.string.Minute));
        else
            time = diff + " " + ((diff > 1) ? context.getString(R.string.Seconds) :
                    context.getString(R.string.Second));
        return (context.getString(R.string.Ago, time));
    }

}
