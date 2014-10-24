package fr.baloomba.ui_lib.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    // <editor-fold desc="STATIC VARIABLES">

    private static final String PREFERENCES_NAME = "Yummypets";

    // </editor-fold>

    // <editor-fold desc="BOOLEAN METHODS">

    public static Boolean getBoolean(Context context, String key, Boolean defaultValue) {
        if (context.getApplicationContext() == null)
            return defaultValue;
        SharedPreferences settings = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        if (context.getApplicationContext() == null)
            return;
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
//        editor.commit();
        editor.apply();
    }

    // </editor-fold>

    // <editor-fold desc="FLOAT METHODS">

    public static Float getFloat(Context context, String key, Float defaultValue) {
        if (context.getApplicationContext() == null)
            return defaultValue;
        SharedPreferences settings = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    public static void putFloat(Context context, String key, Float value) {
        if (context.getApplicationContext() == null)
            return;
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putFloat(key, value);
//        editor.commit();
        editor.apply();
    }

    // </editor-fold>

    // <editor-fold desc="INT METHODS">

    public static int getInt(Context context, String key, int defaultValue) {
        if (context.getApplicationContext() == null)
            return defaultValue;
        SharedPreferences settings = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    public static void putInt(Context context, String key, int value) {
        if (context.getApplicationContext() == null)
            return;
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
//        editor.commit();
        editor.apply();
    }

    // </editor-fold>

    // <editor-fold desc="LONG METHODS">

    public static Long getLong(Context context, String key, Long defaultValue) {
        if (context.getApplicationContext() == null)
            return defaultValue;
        SharedPreferences settings = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    public static void putLong(Context context, String key, Long value) {
        if (context.getApplicationContext() == null)
            return;
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
//        editor.commit();
        editor.apply();
    }

    // </editor-fold>

    // <editor-fold desc="STRING METHODS">

    public static String getString(Context context, String key, String defaultValue) {
        if (context.getApplicationContext() == null)
            return defaultValue;
        SharedPreferences settings = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    public static void putString(Context context, String key, String value) {
        if (context.getApplicationContext() == null)
            return;
        SharedPreferences.Editor editor = context.getApplicationContext()
                .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
//        editor.commit();
        editor.apply();
    }

    //</editor-fold>

}
