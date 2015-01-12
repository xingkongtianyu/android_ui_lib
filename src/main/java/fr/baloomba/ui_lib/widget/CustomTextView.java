package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;

import android.graphics.Typeface;

import android.text.Html;

import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;

import android.util.Log;
import android.widget.TextView;

import fr.baloomba.ui_lib.R;

public class CustomTextView extends TextView {

    private static final String TAG = CustomTextView.class.getSimpleName();

    // <editor-fold desc="VARIABLES">

    private Boolean mAllCaps = false;
    private Boolean mIsHTML = false;
    private Boolean mCapitalize = false;
    private Boolean mHasLink = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CustomTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public void init(Context context, AttributeSet attrs, int defStyle) {
        String customFontFile = null;
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyle, 0);
            if (a != null) {
                customFontFile = a.getString(R.styleable.CustomTextView_customFontFile);
                mAllCaps = a.getBoolean(R.styleable.CustomTextView_uppercase, false);
                mCapitalize = a.getBoolean(R.styleable.CustomTextView_capitalize, false);
                mIsHTML = a.getBoolean(R.styleable.CustomTextView_isHtml, false);
                mHasLink = a.getBoolean(R.styleable.CustomTextView_hasLink, false);
                a.recycle();
            }
        }
        if (customFontFile != null) {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + customFontFile);
            setTypeface(tf);
        }
        if (mHasLink != null && mHasLink) {
            setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            setText(getText());
        }
    }

    // </editor-fold>

    // <editor-fold desc="TEXT VIEW OVERRIDDEN METHODS">

    @Override
    public void setText(CharSequence text, BufferType type) {
        Log.d(TAG, "setText");
        if (mCapitalize != null && mCapitalize && text != null && text.length() > 1)
            text = Character.toUpperCase(text.charAt(0)) + text.toString().substring(1);
        if (mAllCaps != null && mAllCaps && text != null)
            text = text.toString().toUpperCase();
        if (mIsHTML != null && mIsHTML && text != null)
            text = Html.fromHtml(text.toString());
        super.setText(text, type);
    }

    // </editor-fold>

}
