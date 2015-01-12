package fr.baloomba.ui_lib.helper;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class StringHelper {

    private static final String TAG = StringHelper.class.getSimpleName();

    public static String md5(String s) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes(),0,s.length());
            String hash = new BigInteger(1, digest.digest()).toString(16);
            if (hash.length() < 32)
                hash = "0" + hash;
            return hash;
        } catch (NoSuchAlgorithmException e) {
            LogHelper.log(LogHelper.ERROR, e.getMessage());
        }
        return "";
    }

    public static String sha1Hash(String toHash) {
        String hash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(toHash.getBytes(), 0, toHash.length());
            hash = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            LogHelper.log(LogHelper.ERROR, e.getMessage());
        }
        return hash;
    }

    public static Calendar toCalendar(String strDate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        String FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ssZ";
        if (strDate.contains("Z")) {
            strDate = strDate.replace("Z", "+00:00");
            cal.setTimeZone(TimeZone.getTimeZone("utc"));
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
        Date date = sdf.parse(strDate);
        cal.setTime(date);
        return cal;
    }

    public static Calendar toCalendarBlog(String strDate) {
        strDate += "+0200";
        String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ssZ";
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
        Calendar cal = Calendar.getInstance();
        try {
            Date date = sdf.parse(strDate);
            cal.setTime(date);
        } catch (Exception e) {
            LogHelper.log(LogHelper.ERROR, e.getMessage());
        }
        return cal;
    }

    public static String getHour(String date) throws ParseException {
        Calendar calendar = StringHelper.toCalendar(date);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(calendar.getTime());
    }

    public static String escape(String string) {
        string = string.replace("<3", "&#9829;");
        return string;
    }

    public static String getStringResource(Context context, String key) {
        int resId = context.getResources().getIdentifier(key, "string", context.getPackageName());
        if (resId <= 0) {
            Log.e(TAG, key);
//            throw new Resources.NotFoundException();
            return key;
        }
        return context.getString(resId);
    }

}
