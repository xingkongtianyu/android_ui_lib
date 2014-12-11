package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;

import android.graphics.Typeface;

import android.util.AttributeSet;

import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import fr.baloomba.ui_lib.R;
import fr.baloomba.ui_lib.helper.ViewHelper;

public class CustomTextView extends TextView {

    // <editor-fold desc="VARIABLES">

    private Context mContext;

    private Boolean mAllCaps = false;
    private Boolean mIsHTML = false;
    private Boolean mCapitalize = false;
    private String mCustomFontFile = null;
    private Boolean mHasLink = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public CustomTextView(Context context) {
        super(context);
        initCustomTextView(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCustomTextView(context);
        initCustomTextViewFromAttributes(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initCustomTextView(context);
        initCustomTextViewFromAttributes(context, attrs);
    }

    // </editor-fold>

    // <editor-fold desc="TEXT VIEW OVERRIDDEN METHODS">

//    @Override
//    public void setText(CharSequence text, BufferType type) {
//        if (mCapitalize != null && mCapitalize && text != null && text.length() > 1)
//            text = Character.toUpperCase(text.charAt(0)) + text.toString().substring(1);
//        if (mAllCaps != null && mAllCaps && text != null)
//            text = text.toString().toUpperCase();
//        if (mIsHTML != null && mIsHTML && text != null)
//            text = Html.fromHtml(text.toString());
//        if (mHasLink != null && mHasLink)
//            setMovementMethod(LinkMovementMethod.getInstance());
//        super.setText(text, type);
//    }

//    @Override
//    public CharSequence getText() {
//        CharSequence charSequence = super.getText();
//        return (mAllCaps && charSequence != null) ? charSequence.toString().toUpperCase() : charSequence;
//    }

    // </editor-fold>

    // <editor-fold desc="SETTERS">

    @Override
    public void setAllCaps(boolean allCaps) {
        mAllCaps = allCaps;
        setText(getText());
    }

    public void setCapitalize(Boolean capitalize) {
        mCapitalize = capitalize;
        setText(getText());
    }

    public void setIsHTML(Boolean isHTML) {
        mIsHTML = isHTML;
        setText(getText());
    }

    public void setHasLink(Boolean hasLink) {
        mHasLink = hasLink;
        setText(getText());
    }

    public void setCustomFontFile(String customFontFile) {
        mCustomFontFile = customFontFile;
        if (mCustomFontFile != null) {
            try {
                Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/" + mCustomFontFile);
                setTypeface(tf);
                invalidate();
            } catch (Exception ignored) {}
        }
    }

    public void setEnable(boolean enable) {
        ViewHelper.setAlpha(this, .5f);
    }

    // </editor-fold>

    // <editor-fold desc="GETTERS">

    public Boolean getAllCaps() {
        return mAllCaps;
    }

    public Boolean getCapitalize() {
        return mCapitalize;
    }

    public Boolean getIsHTML() {
        return mIsHTML;
    }

    public Boolean getHasLink() {
        return mHasLink;
    }

    public String getCustomFontFile() {
        return mCustomFontFile;
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    private void initCustomTextView(Context context) {
        mContext = context;
    }

    private void initCustomTextViewFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);

        final int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.CustomTextView_customFontFile) {
                setCustomFontFile(a.getString(attr));
            } else if (attr == R.styleable.CustomTextView_uppercase) {
                setAllCaps(a.getBoolean(attr, false));
            } else if (attr == R.styleable.CustomTextView_capitalize) {
                setCapitalize(a.getBoolean(attr, false));
            } else if (attr == R.styleable.CustomTextView_isHtml) {
                setIsHTML(a.getBoolean(attr, false));
            } else if (attr == R.styleable.CustomTextView_hasLink) {
                setIsHTML(a.getBoolean(attr, false));
            }
        }
//        setText(getText());
    }

    public void displayAvailableFonts() {
        Resources res = getResources();
        AssetManager am = res.getAssets();
        try {
            String fileList[] = am.list("fonts");
            for (String file : fileList) {
                Log.d("", file);
            }
        } catch (IOException e) {
            Log.e("", e.getMessage());
        }
    }

    // </editor-fold>

}
