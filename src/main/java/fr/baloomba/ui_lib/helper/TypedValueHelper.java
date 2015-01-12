package fr.baloomba.ui_lib.helper;

import android.content.Context;
import android.util.TypedValue;

public class TypedValueHelper {

    public static int applyDimensionDIP(Context context, float value) {
        return (int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                value, context.getResources().getDisplayMetrics()) + .5f);
    }

}
