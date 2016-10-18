package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment demonstrating a simple submit button
 * The submit button sends out a submit toast
 */
public class Input_SubmitButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_submit_button_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.input_submit_button)
    public void onClick(){
        Toast.makeText(getActivity(), getString(R.string.submit_button_toast_message), Toast.LENGTH_SHORT).show();
    }
}
