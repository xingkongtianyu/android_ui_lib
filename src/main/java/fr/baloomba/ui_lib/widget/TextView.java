package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;

import android.graphics.Typeface;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;

import fr.baloomba.ui_lib.R;
import fr.baloomba.ui_lib.helper.TypeFaceHelper;
import fr.baloomba.ui_lib.helper.ViewHelper;

public class TextView extends android.widget.TextView {

    // <editor-fold desc="VARIABLES">

    private Context mContext;

    private Boolean mIsUppercase = false;
    private Boolean mIsHTML = false;
    private Boolean mCapitalize = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public TextView(Context context) {
        super(context);
        init(context);
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initWithAttributes(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyle) {
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
            if (mCapitalize && !mIsUppercase) {
                charSequence = Character.toUpperCase(charSequence.charAt(0))
                        + charSequence.toString().substring(1);
            } else if (mIsUppercase) {
                charSequence = charSequence.toString().toUpperCase();
            }
            if (mIsHTML) {
                charSequence = Html.fromHtml(charSequence.toString());
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

    public void setCapitalize(Boolean capitalize) {
        mCapitalize = capitalize;
        setText(getText());
    }

    public void setIsHTML(Boolean isHTML) {
        mIsHTML = isHTML;
        setText(getText());
    }

    public void setHasLink(boolean hasLink) {
        if (hasLink)
            setMovementMethod(LinkMovementMethod.getInstance());
        else
            setMovementMethod(null);
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
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.TextView_customFontFile) {
                setCustomFontFile(a.getString(attr));
            } else if (attr == R.styleable.TextView_uppercase) {
                setIsUppercase(a.getBoolean(attr, false));
            } else if (attr == R.styleable.TextView_capitalize) {
                setCapitalize(a.getBoolean(attr, false));
            } else if (attr == R.styleable.TextView_isHtml) {
                setIsHTML(a.getBoolean(attr, false));
            } else if (attr == R.styleable.TextView_hasLink) {
                setHasLink(a.getBoolean(attr, false));
            }
        }
//        setText(getText());
    }

    // </editor-fold>

}
