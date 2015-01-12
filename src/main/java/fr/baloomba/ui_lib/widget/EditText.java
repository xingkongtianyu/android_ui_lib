package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import fr.baloomba.ui_lib.R;
import fr.baloomba.ui_lib.helper.TypeFaceHelper;
import fr.baloomba.ui_lib.helper.ViewHelper;

public class EditText extends android.widget.EditText {

    // <editor-fold desc="VARIABLES">

    private Context mContext;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public EditText(Context context) {
        super(context);
        init(context);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initWithAttributes(context, attrs);
    }

    public EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        initWithAttributes(context, attrs);
    }

    // </editor-fold>

    // <editor-fold desc="SETTERS">

    public void setCustomFontFile(String customFontFile) {
        if (customFontFile != null) {
            Typeface tf = TypeFaceHelper.getTypeface(mContext.getAssets(), customFontFile);
            setTypeface(tf);
            invalidate();
        }
    }

    // </editor-fold>

    // <editor-fold desc="EDIT TEXT OVERRIDDEN METHODS">

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ViewHelper.setAlpha(this, enabled ? 1f : .5f);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    private void init(Context context) {
        mContext = context;
    }

    private void initWithAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditText);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.EditText_customFontFile) {
                setCustomFontFile(a.getString(attr));
            }
        }
    }

    // </editor-fold>

}
