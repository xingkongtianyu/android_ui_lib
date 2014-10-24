package fr.baloomba.ui_lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import fr.baloomba.ui_lib.R;

public class Loader extends ProgressBar {

    // <editor-fold desc="VARIABLES">

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public Loader(Context context) {
        super(context);
        init(context, null, 0);
    }

    public Loader(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public Loader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    private void init(Context context, AttributeSet attrs, int defStyle) {
        int animationRes;
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Loader, defStyle, 0);
            animationRes = a.getInteger(R.styleable.Loader_animation, R.anim.rotation_progress);
            Animation animation = AnimationUtils.loadAnimation(context, animationRes);
            startAnimation(animation);
            a.recycle();
        }
    }

    // </editor-fold>

}
