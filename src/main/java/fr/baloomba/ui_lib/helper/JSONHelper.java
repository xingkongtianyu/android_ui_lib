package fr.baloomba.ui_lib.helper;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHelper {

    private static final String TAG = JSONHelper.class.getSimpleName();
    
    public static Object get(JSONObject object, String key) throws JSONException {
        Object obj = null;
        if (object != null && object.has(key) && !object.isNull(key))
            obj = object.get(key);
        return obj;
    }

    public static Object get(JSONObject object, String key, Object defaultValue)
            throws JSONException {
        Object obj = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            obj = object.get(key);
        return obj;
    }

    public static JSONObject getJSONObject(JSONObject object, String key) throws JSONException {
        JSONObject jsonObject = null;
        if (object != null && object.has(key) && !object.isNull(key))
            jsonObject = object.getJSONObject(key);
        return jsonObject;
    }

    public static JSONArray getJSONArray(JSONObject object, String key) throws JSONException {
        JSONArray jsonArray = null;
        if (object != null && object.has(key) && !object.isNull(key))
            jsonArray = object.getJSONArray(key);
        return jsonArray;
    }

    public static String getString(JSONObject object, String key) throws JSONException {
        String string = null;
        if (object != null && object.has(key) && !object.isNull(key))
            string = object.getString(key);
        return string;
    }

    public static String getString(JSONObject object, String key, String defaultValue)
            throws JSONException {
        String string = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            string = object.getString(key);
        return string;
    }

    public static Boolean getBoolean(JSONObject object, String key) throws JSONException {
        Boolean bool = false;
        if (object != null && object.has(key) && !object.isNull(key))
            bool = object.getBoolean(key);
        return bool;
    }

    public static Boolean getBoolean(JSONObject object, String key, Boolean defaultValue)
            throws JSONException {
        Boolean bool = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            bool = object.getBoolean(key);
        return bool;
    }

    public static Double getDouble(JSONObject object, String key) throws JSONException {
        Double d = .0;
        if (object != null && object.has(key) && !object.isNull(key))
            d = object.getDouble(key);
        return d;
    }

    public static Double getDouble(JSONObject object, String key, Double defaultValue)
            throws JSONException {
        Double d = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            d = object.getDouble(key);
        return d;
    }

    public static Integer getInt(JSONObject object, String key) throws JSONException {
        Integer integer = 0;
        if (object != null && object.has(key) && !object.isNull(key))
            integer = object.getInt(key);
        return integer;
    }

    public static Integer getInt(JSONObject object, String key, Integer defaultValue)
            throws JSONException {
        Integer integer = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            integer = object.getInt(key);
        return integer;
    }

    public static Long getLong(JSONObject object, String key) throws JSONException {
        Long l = 0l;
        if (object != null && object.has(key) && !object.isNull(key))
            l = object.getLong(key);
        return l;
    }

    public static Long getLong(JSONObject object, String key, Long defaultValue)
            throws JSONException {
        Long l = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key))
            l = object.getLong(key);
        return l;
    }
    
    public static Float getFloat(JSONObject object, String key) throws JSONException {
        Float f = 0f;
        if (object != null && object.has(key) && !object.isNull(key)) {
            String string = object.getString(key);
            try {
                f = Float.parseFloat(string);
            } catch (NumberFormatException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return f;
    }
    
    public static Float getFloat(JSONObject object, String key, Float defaultValue) throws JSONException {
        Float f = defaultValue;
        if (object != null && object.has(key) && !object.isNull(key)) {
            String string = object.getString(key);
            try {
                f = Float.parseFloat(string);
            } catch (NumberFormatException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return f;
    }

}
