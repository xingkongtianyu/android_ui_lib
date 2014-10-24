package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import fr.baloomba.ui_lib.R;

public class RoundedImageView extends ImageView {

    // <editor-fold desc="VARIABLES">

//    public static final String TAG = "RoundedFadedNetworkImageView";
    public static final int DEFAULT_RADIUS = 0;
    public static final int DEFAULT_BORDER_WIDTH = 0;
    private static final ScaleType[] sScaleTypeArray = {
            ScaleType.MATRIX,
            ScaleType.FIT_XY,
            ScaleType.FIT_START,
            ScaleType.FIT_CENTER,
            ScaleType.FIT_END,
            ScaleType.CENTER,
            ScaleType.CENTER_CROP,
            ScaleType.CENTER_INSIDE
    };
    private int mCornerRadius = DEFAULT_RADIUS;
    private int mBorderWidth = DEFAULT_BORDER_WIDTH;
    private ColorStateList mBorderColor = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
    private boolean mRoundBackground = false;
    private boolean mOval = false;
    private Drawable mDrawable;
    private Drawable mBackgroundDrawable;
    private ScaleType mScaleType;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    @SuppressWarnings("unused")
    public RoundedImageView(Context context) {
        super(context);
    }

    @SuppressWarnings("unused")
    public RoundedImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressWarnings("null")
    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundedImageView,
                defStyle, 0);

        int index = a != null ? a.getInt(R.styleable.RoundedImageView_android_scaleType, -1) : -1;
        if (index >= 0) {
            setScaleType(sScaleTypeArray[index]);
        }

        mCornerRadius = a != null ?
                a.getDimensionPixelSize(R.styleable.RoundedImageView_corner_radius, DEFAULT_RADIUS)
                : DEFAULT_RADIUS;
        mBorderWidth = a != null ?
                a.getDimensionPixelSize(R.styleable.RoundedImageView_border_width,
                        DEFAULT_BORDER_WIDTH) : DEFAULT_BORDER_WIDTH;

        // don't allow negative values for radius and border
        if (mCornerRadius < 0) {
            mCornerRadius = DEFAULT_RADIUS;
        }
        if (mBorderWidth < 0) {
            mBorderWidth = DEFAULT_BORDER_WIDTH;
        }

        mBorderColor = a != null ? a.getColorStateList(R.styleable.RoundedImageView_border_color) :
                ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        if (mBorderColor == null) {
            mBorderColor = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        }

        mRoundBackground = a != null &&
                a.getBoolean(R.styleable.RoundedImageView_round_background, false);
        mOval = a != null && a.getBoolean(R.styleable.RoundedImageView_is_oval, false);

        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();

        if (a != null)
            a.recycle();
    }

    // </editor-fold>

    // <editor-fold desc="NETWORK IMAGE VIEW OVERRIDDEN METHODS">

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /**
     * Return the current scale type in use by this ImageView.
     *
     * @attr ref android.R.styleable#ImageView_scaleType
     * @see android.widget.ImageView.ScaleType
     */
    @Override
    public ScaleType getScaleType() {
        return mScaleType;
    }

    /**
     * Controls how the image should be resized or moved to match the size
     * of this ImageView.
     *
     * @param scaleType The desired scaling mode.
     * @attr ref android.R.styleable#ImageView_scaleType
     */
    @Override
    public void setScaleType(ScaleType scaleType) {
        if (scaleType == null) {
            throw new NullPointerException();
        }

        if (mScaleType != scaleType) {
            mScaleType = scaleType;

            switch (scaleType) {
                case CENTER:
                case CENTER_CROP:
                case CENTER_INSIDE:
                case FIT_CENTER:
                case FIT_START:
                case FIT_END:
                case FIT_XY:
                    super.setScaleType(ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }

            updateDrawableAttrs();
            updateBackgroundDrawableAttrs();
            invalidate();
        }
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            mDrawable = RoundedDrawable.fromDrawable(drawable);
            updateDrawableAttrs();
        } else {
            mDrawable = null;
        }
        super.setImageDrawable(mDrawable);
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        if (bm != null) {
            mDrawable = new RoundedDrawable(bm);
            updateDrawableAttrs();
        } else {
            mDrawable = null;
        }
        super.setImageDrawable(mDrawable);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setBackground(Drawable background) {
        setBackgroundDrawable(background);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public void setBackgroundDrawable(Drawable background) {
        mBackgroundDrawable = RoundedDrawable.fromDrawable(background);
        updateBackgroundDrawableAttrs();
        super.setBackgroundDrawable(mBackgroundDrawable);
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        setImageDrawable(getDrawable());
    }

    // </editor-fold>

    // <editor-fold desc="GETTERS">

    @SuppressWarnings("unused")
    public int getCornerRadius() {
        return mCornerRadius;
    }

    @SuppressWarnings("unused")
    public int getBorderWidth() {
        return mBorderWidth;
    }

    @SuppressWarnings("unused")
    public int getBorderColor() {
        return mBorderColor.getDefaultColor();
    }

    @SuppressWarnings("unused")
    public ColorStateList getBorderColors() {
        return mBorderColor;
    }

    @SuppressWarnings("unused")
    public boolean isOval() {
        return mOval;
    }

    @SuppressWarnings("unused")
    public boolean isRoundBackground() {
        return mRoundBackground;
    }

    // </editor-fold>

    // <editor-fold desc="SETTERS">

    @SuppressWarnings("unused")
    public void setCornerRadius(int radius) {
        if (mCornerRadius == radius) {
            return;
        }

        mCornerRadius = radius;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
    }

    @SuppressWarnings("unused")
    public void setBorderWidth(int width) {
        if (mBorderWidth == width) {
            return;
        }

        mBorderWidth = width;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setBorderColor(int color) {
        setBorderColors(ColorStateList.valueOf(color));
    }

    public void setBorderColors(ColorStateList colors) {
        if (mBorderColor.equals(colors)) {
            return;
        }

        mBorderColor = (colors != null) ? colors : ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
        if (mBorderWidth > 0) {
            invalidate();
        }
    }

    @SuppressWarnings("unused")
    public void setOval(boolean oval) {
        mOval = oval;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs();
        invalidate();
    }

    @SuppressWarnings("unused")
    public void setRoundBackground(boolean roundBackground) {
        if (mRoundBackground == roundBackground) {
            return;
        }

        mRoundBackground = roundBackground;
        updateBackgroundDrawableAttrs();
        invalidate();
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    private void updateDrawableAttrs() {
        updateAttrs(mDrawable, false);
    }

    private void updateBackgroundDrawableAttrs() {
        updateAttrs(mBackgroundDrawable, true);
    }

    private void updateAttrs(Drawable drawable, boolean background) {
        if (drawable == null) {
            return;
        }

        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).setScaleType(mScaleType)
                    .setCornerRadius(!mRoundBackground && background ? 0 : mCornerRadius)
                    .setBorderWidth(!mRoundBackground && background ? 0 : mBorderWidth)
                    .setBorderColors(mBorderColor)
                    .setOval(mOval);
        } else if (drawable instanceof LayerDrawable) {
            // loop through layers to and set drawable attrs
            LayerDrawable ld = ((LayerDrawable) drawable);
            int layers = ld.getNumberOfLayers();
            for (int i = 0; i < layers; i++) {
                updateAttrs(ld.getDrawable(i), background);
            }
        }
    }

    // </editor-fold>

}