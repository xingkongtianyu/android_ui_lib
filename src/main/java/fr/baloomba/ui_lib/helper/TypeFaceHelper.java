package fr.baloomba.ui_lib.helper;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;

public class TypeFaceHelper {

    private static final String TAG = TypeFaceHelper.class.getSimpleName();

    // <editor-fold desc="VARIABLES">

    private static HashMap<String, Typeface> sTypefaces = new HashMap<>();

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public static Typeface getTypeface(AssetManager assetManager, String key) {
        Typeface typeface = sTypefaces.get(key);
        if (typeface == null) {
            Log.d(TAG, "create typeface:" + key);
            typeface = Typeface.createFromAsset(assetManager, "fonts/" + key);
            if (typeface != null)
                sTypefaces.put(key, typeface);
        }
        return typeface;
    }

    // </editor-fold>

}
