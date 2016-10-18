package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qualifylabs.devicelab.android.referenceapp.R;

/**
 * A simple fragment for static content
 */
public class SimpleFragment extends Fragment {

    private int layoutID;

    public SimpleFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutID = getArguments().getInt(getResources().getString(R.string.FRAGMENT_ID_BUNDLE_KEY));
    }

    /**
     * Loads the layout from the passed resource int
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layoutID, container, false);
    }
}
