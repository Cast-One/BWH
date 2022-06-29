package com.castillo.breathewithme.ToolsApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ToolsBreathe {
    public static void nextActivity(Class nextActivity, Context context){
        try {
            Activity activity = (Activity)context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
        }catch(Exception ignored){}
    }

    public static void nextActivityFinish(Context context, Class nextActivity){
        try {
            Activity activity = (Activity) context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
            activity.finish();
        }catch(Exception ignored){}
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
