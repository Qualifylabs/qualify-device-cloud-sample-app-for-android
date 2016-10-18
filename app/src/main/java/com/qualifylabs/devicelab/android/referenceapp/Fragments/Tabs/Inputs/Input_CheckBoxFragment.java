package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating a checkbox input
 */
public class Input_CheckBoxFragment extends Fragment implements CheckBox.OnCheckedChangeListener{
    @InjectView(R.id.input_checkbox_status)
    TextView checkbox_display;

    @InjectView(R.id.input_checkbox)
    CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_checkbox_fragment, container, false);
        ButterKnife.inject(this, view);
        changeDisplay();
        checkBox.setOnCheckedChangeListener(this);
        return view;
    }

    /**
     * Changes the display, reflecting a checkbox's status
     */
    private void changeDisplay(){
        if (checkBox.isChecked()) {
            checkbox_display.setText("Checked");
        } else {
            checkbox_display.setText("Unchecked");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        changeDisplay();
    }
}
