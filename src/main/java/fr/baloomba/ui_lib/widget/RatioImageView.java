package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import fr.baloomba.ui_lib.R;

public class RatioImageView extends android.widget.ImageView {

    // <editor-fold desc="VARIABLES">

    private static final String TAG = RatioImageView.class.getSimpleName();

    private Boolean mRatio = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    @SuppressWarnings("unused")
    public RatioImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    @SuppressWarnings("unused")
    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    @SuppressWarnings("unused")
    public RatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    // </editor-fold>

    // <editor-fold desc="IMAGE VIEW OVERRIDDEN METHODS">

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Drawable drawable = getDrawable();
        if (mRatio && drawable != null) {
            float ratio = (float)drawable.getIntrinsicHeight() / (float)drawable.getIntrinsicWidth();
            height = (int)(ratio * width);
        }
        setMeasuredDimension(width, height);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public void init(Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView,
                    defStyle, 0);
            if (a != null) {
                mRatio = a.getBoolean(R.styleable.RatioImageView_use_ratio, false);
                a.recycle();
            }
        }
    }

    // </editor-fold>

}