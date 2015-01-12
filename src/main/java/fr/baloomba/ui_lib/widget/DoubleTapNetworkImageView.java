package fr.baloomba.ui_lib.widget;

import android.content.Context;

import android.support.v4.view.GestureDetectorCompat;

import android.util.AttributeSet;

import android.view.GestureDetector;
import android.view.MotionEvent;

import fr.baloomba.wsvolley.widget.NetworkImageView;

import fr.baloomba.ui_lib.listener.OnGestureListener;

public class DoubleTapNetworkImageView extends NetworkImageView {

    private static final String TAG = DoubleTapNetworkImageView.class.getSimpleName();

    // <editor-fold desc="VARIABLES">

    private GestureDetectorCompat mGestureDetector;
    private OnGestureListener mListener;

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    public DoubleTapNetworkImageView(Context context) {
        super(context);
    }

    public DoubleTapNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetectorCompat(context, new GestureListener());
    }

    public DoubleTapNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mGestureDetector = new GestureDetectorCompat(context, new GestureListener());
    }

    // </editor-fold

    // <editor-fold desc="SETTERS">

    public void setOnDoubleTapListener(OnGestureListener listener) {
        mListener = listener;
    }

    // </editor-fold>

    // <editor-fold desc="NETWORK IMAGE VIEW OVERRIDDEN METHODS">

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return mGestureDetector.onTouchEvent(e);
    }

    // </editor-fold>

    // <editor-fold desc="GESTURE LISTENER">

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mListener == null)
                return callOnClick();
//                throw new NullPointerException("DoubleTapImageView needs OnGestureListener");
            return mListener.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (mListener == null)
                return callOnClick();
//                throw new NullPointerException("DoubleTapImageView needs OnGestureListener");
            return mListener.onDoubleTap(e);
        }
    }

    // </editor-fold>

}
