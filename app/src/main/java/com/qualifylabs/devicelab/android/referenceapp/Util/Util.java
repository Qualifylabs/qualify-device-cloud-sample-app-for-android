package com.qualifylabs.devicelab.android.referenceapp.Util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Utility class
 */
public final class Util {

    /**
     * Hides the software keyboard
     * @param editText the editText editText
     * @param context the fragment's context
     */
    public static void hideKeyboard(EditText editText, Context context){
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
