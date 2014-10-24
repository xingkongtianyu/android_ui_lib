package fr.baloomba.ui_lib.widget;

import android.content.Context;

import android.graphics.Typeface;

import android.util.AttributeSet;

import android.widget.Button;

import fr.baloomba.ui_lib.helper.CharSequenceHelper;

public class CustomButton extends Button {

    private Boolean mAllCaps = false;

    public CustomButton(Context context) {
        super(context);
        init(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/FreigSanProBook.otf");
        mAllCaps = false;
        if (attrs != null) {
            int textStyle = attrs.getAttributeIntValue(
                    "http://schemas.android.com/apk/res-auto", "customTextStyle", 0);
            switch (textStyle) {
                case -2: // numberBold
                    tf = Typeface.createFromAsset(context.getAssets(),
                            "fonts/Museo_SlabBold.otf");
                    break;
                case -1: // number
                    tf = Typeface.createFromAsset(context.getAssets(),
                            "fonts/Museo_Slab.otf");
                    break;
//                case 1: // bookItalic
//                    tf = Typeface.createFromAsset(context.getAssets(),
//                            "fonts/FreigSanProBookIt.otf");
//                    break;
                case 2: // bold
                    tf = Typeface.createFromAsset(context.getAssets(),
                            "fonts/FreigSanProBold.otf");
                    break;
//                case 3: // light
//                    tf = Typeface.createFromAsset(context.getAssets(),
//                            "fonts/FreigSanProLig.otf");
//                    break;
//                case 4: // lightItalic
//                    tf = Typeface.createFromAsset(context.getAssets(),
//                            "fonts/FreigSanProLigIt.otf");
//                    break;
//                case 5: // medium
//                    tf = Typeface.createFromAsset(context.getAssets(),
//                            "fonts/FreigSanProBook.otf");
//                    break;
                case 0: // book
                default:
                    tf = Typeface.createFromAsset(context.getAssets(),
                            "fonts/FreigSanProBook.otf");
            }
            mAllCaps = attrs.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto",
                    "uppercase", false);
        }
        setTypeface(tf);
        if (mAllCaps)
            setText(CharSequenceHelper.toString(getText()).toUpperCase());
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (mAllCaps != null && mAllCaps)
            text = text.toString().toUpperCase();
        super.setText(text, type);
    }
}
