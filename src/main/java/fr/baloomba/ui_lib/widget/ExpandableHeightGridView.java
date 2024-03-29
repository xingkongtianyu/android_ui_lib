package fr.baloomba.ui_lib.widget;

import android.content.Context;

import android.util.AttributeSet;

import android.view.ViewGroup;

public class ExpandableHeightGridView extends android.widget.GridView {

    // <editor-fold desc="VARIABLES">

    private boolean mExpanded = false;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public ExpandableHeightGridView(Context context) {
        super(context);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableHeightGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    public boolean isExpanded() {
        return mExpanded;
    }

    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    // </editor-fold>

    // <editor-fold desc="GRID VIEW OVERRIDDEN METHODS">

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // HACK! TAKE THAT ANDROID!
        if (isExpanded()) {
            // Calculate entire height by providing a very large height hint.
            // But do not use the highest 2 bits of this integer; those are
            // reserved for the MeasureSpec mode.
            int expandSpec = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);

            ViewGroup.LayoutParams params = getLayoutParams();
            params.height = getMeasuredHeight();
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    // </editor-fold>

}