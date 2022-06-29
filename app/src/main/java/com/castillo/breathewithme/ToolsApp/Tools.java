package com.castillo.breathewithme.ToolsApp;

import static android.view.View.*;

import android.annotation.SuppressLint;
import  android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.castillo.breathewithme.R;

public class Tools {
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

    public static  void openFragment(Integer id_frame, Fragment fragment, FragmentTransaction transaction) {
        transaction.setCustomAnimations(R.anim.fadein, R.anim.fadein, R.anim.fadeout, R.anim.fadeout);
        transaction.replace(id_frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static  void openProgress(FragmentTransaction transaction, Context context) {
        Activity activity = (Activity) context;
        ProgressFragment progressFragment = new ProgressFragment();
        View view = activity.findViewById(R.id.id_progress_fragment);
        view.setVisibility(VISIBLE);
        transaction.setCustomAnimations(R.anim.fadein, R.anim.fadein, R.anim.fadeout, R.anim.fadeout);
        transaction.replace(R.id.id_progress_fragment, progressFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public static  void offProgress(Context context) {
        Activity activity = (Activity) context;
//        ProgressFragment progressFragment = new ProgressFragment();
        View view = activity.findViewById(R.id.id_progress_fragment);
        view.setVisibility(GONE);
//        transaction.setCustomAnimations(R.anim.fadein, R.anim.fadein, R.anim.fadeout, R.anim.fadeout);
//        transaction.replace(R.id.id_progress_fragment, progressFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }




}
