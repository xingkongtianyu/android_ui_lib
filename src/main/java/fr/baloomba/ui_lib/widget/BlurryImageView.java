package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BlurryImageView extends ImageView {

    // <editor-fold desc="VARIABLES">

    private int mBlurRadius = 10;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public BlurryImageView(Context context) {
        super(context);
    }

    public BlurryImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BlurryImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    // </editor-fold>

    // <editor-fold desc="IMAGE VIEW OVERRIDDEN METHODS">

    @Override
    public void setImageBitmap(Bitmap bm) {
        Bitmap bmo = bm.copy(Bitmap.Config.ARGB_8888, true);
        functionToBlur(bm, bmo, mBlurRadius);
        super.setImageBitmap(bmo);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public void setBlurRadius(int blurRadius) {
        mBlurRadius = blurRadius;
    }

    private native void functionToBlur(Bitmap in, Bitmap out, int radius);

    static {
        System.loadLibrary("blur");
    }

    // </editor-fold>

}
