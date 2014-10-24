package fr.baloomba.ui_lib.helper;

import android.text.Editable;

public class EditableHelper {

    public static String toString(Editable editable) {
        return editable != null ? editable.toString() : "";
    }

}
