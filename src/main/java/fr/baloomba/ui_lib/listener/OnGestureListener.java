package fr.baloomba.ui_lib.listener;

import android.view.MotionEvent;

public interface OnGestureListener {

    /**
     * Notified when a double-tap occurs.
     *
     * @param e The down motion event of the first tap of the double-tap.
     * @return true if event is consumed, else false
     */
    boolean onSingleTapConfirmed(MotionEvent e);

    boolean onDoubleTap(MotionEvent e);
}
