package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;

import android.util.AttributeSet;

import fr.baloomba.ui_lib.R;

public class WebView extends android.webkit.WebView {

    // <editor-fold desc="VARIABLES">

    protected String mContentHead;
    protected String mContentBody;
    protected Boolean mTransparentBackground = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public WebView(Context context) {
        super(context);
        init(context);
        init(context, null, 0);
    }

    public WebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initWithAttributes(context, attrs);
        init(context, attrs, 0);
    }

    public WebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        initWithAttributes(context, attrs);
        init(context, attrs, defStyle);
    }

    // </editor-fold>

    // <editor-fold desc="SETTERS">

    public void setContentHead(String contentHead) {
        mContentHead = contentHead;
        fill();
    }

    public void setContentBody(String contentBody) {
        mContentBody = contentBody;
        fill();
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    protected void init(Context context) {}

    protected void initWithAttributes(Context context, AttributeSet attrs) {

    }

    protected void init(Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WebView,
                    defStyle, 0);
            if (a != null) {
                mContentHead = a.getString(R.styleable.WebView_head);
                mContentBody = a.getString(R.styleable.WebView_body);
                mTransparentBackground = a.getBoolean(R.styleable.WebView_transparentBackground, false);
                a.recycle();
            }
        }
        fill();
    }

    public void fill() {
        String content = "<!DOCTYPE html><html>";
        if (mContentHead != null)
            content += "<head>" + mContentHead + "</head>";
        content += "<body>" + mContentBody + "</body>" + "</html>";
        loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);
        if (mTransparentBackground)
            setBackgroundColor(0x00000000);
    }

    // </editor-fold>

}
