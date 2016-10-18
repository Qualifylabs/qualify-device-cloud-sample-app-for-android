package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment with a known error
 */
public class crashFragment extends Fragment {

    public crashFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crash_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * Button to crash the app
     */
    @OnClick(R.id.crash_button)
    public void onCrashButton(){
        //will crash the app (dividing by zero)
        int i = 1 / 0;
    }
}
