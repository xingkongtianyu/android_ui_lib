package fr.baloomba.ui_lib.helper;

import android.util.Log;
import fr.baloomba.ui_lib.BuildConfig;

public class LogHelper {

    //<editor-fold desc="VARIABLES">

    private static final Boolean SUPER_DEBUG_ENABLED = false;

    public static final int SUPER_DEBUG = 1;

    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    //</editor-fold>

    // <editor-fold desc="METHODS">

    public static void log(int logMode, String message) {
        log(logMode, "", message);
    }

    public static void log(int logMode, String tag, String message) {
        tag = BuildConfig.APPLICATION_ID + ":" + tag;
        message = ((message == null) ? "[LOGGER MESSAGE] - null" : ((message.length() > 0) ?
                message : "[LOGGER MESSAGE] - Empty log string"));
        switch (logMode) {
            case SUPER_DEBUG:
                if (SUPER_DEBUG_ENABLED)
                    Log.d(tag, message);
                break;
            case DEBUG:
                if (BuildConfig.DEBUG || SUPER_DEBUG_ENABLED)
                    Log.d(tag, message);
                break;
            case ERROR:
                if (BuildConfig.DEBUG || SUPER_DEBUG_ENABLED)
                    Log.e(tag, message);
                break;
            case INFO:
                if (BuildConfig.DEBUG || SUPER_DEBUG_ENABLED)
                    Log.i(tag, message);
                break;
            case VERBOSE:
                if (BuildConfig.DEBUG || SUPER_DEBUG_ENABLED)
                    Log.v(tag, message);
                break;
            case WARN:
                if (BuildConfig.DEBUG || SUPER_DEBUG_ENABLED)
                    Log.w(tag, message);
                break;
            default:
                break;
        }
    }

    public static void log(int logMode, String app, String tag, String message) {
        log(logMode, app + ":" + tag, message);
    }

    // </editor-fold>

}
