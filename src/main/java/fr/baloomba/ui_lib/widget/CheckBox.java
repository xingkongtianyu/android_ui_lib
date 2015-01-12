package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import fr.baloomba.ui_lib.R;
import fr.baloomba.ui_lib.helper.TypeFaceHelper;
import fr.baloomba.ui_lib.helper.ViewHelper;

public class CheckBox extends android.widget.CheckBox {

    // <editor-fold desc="VARIABLES">

    private Context mContext;

    private Boolean mIsUppercase = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public CheckBox(Context context) {
        super(context);
        init(context);
    }

    public CheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initWithAttributes(context, attrs);
    }

    public CheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        initWithAttributes(context, attrs);
    }

    // </editor-fold>

    // <editor-fold desc="TEXT VIEW OVERRIDDEN METHODS">

    @Override
    public CharSequence getText() {
        CharSequence charSequence = super.getText();
        if (charSequence != null) {
            if (mIsUppercase) {
                charSequence = charSequence.toString().toUpperCase();
            }
            return charSequence;
        }
        return null;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ViewHelper.setAlpha(this, enabled ? 1f : .5f);
    }

    // </editor-fold>

    // <editor-fold desc="SETTERS">

    public void setIsUppercase(boolean isUppercase) {
        mIsUppercase = isUppercase;
        setText(getText());
    }

    public void setCustomFontFile(String customFontFile) {
        if (customFontFile != null) {
            Typeface tf = TypeFaceHelper.getTypeface(mContext.getAssets(), customFontFile);
            setTypeface(tf);
            invalidate();
        }
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    private void init(Context context) {
        mContext = context;
    }

    private void initWithAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CheckBox);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.CheckBox_customFontFile) {
                setCustomFontFile(a.getString(attr));
            } else if (attr == R.styleable.CheckBox_uppercase) {
                setIsUppercase(a.getBoolean(attr, false));
            }
        }
    }

    // </editor-fold>

}
