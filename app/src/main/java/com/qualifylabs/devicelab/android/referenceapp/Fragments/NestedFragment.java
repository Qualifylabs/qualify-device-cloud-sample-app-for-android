package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qualifylabs.devicelab.android.referenceapp.Activities.BackNavigationActivity;
import com.qualifylabs.devicelab.android.referenceapp.Activities.UpNavigationActivity;
import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedFragment extends Fragment {

    public NestedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nested_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * displays the back button activity
     */
    @OnClick(R.id.nested_back_button)
    public void backButtonOnClick() {
        getActivity().startActivity(new Intent(getActivity(), BackNavigationActivity.class));
    }

    /**
     * Displays the up navigation activity
     */
    @OnClick(R.id.nested_up_button)
    public void upButtonOnClick() {
        getActivity().startActivity(new Intent(getActivity(), UpNavigationActivity.class));
    }
}
