package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A fragment demonstrating the toggle button
 */
public class Input_Toggle_ButtonFragment extends Fragment {
    @InjectView(R.id.input_switch_display)
    View switchDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_toggle_button_fragment, container, false);
        ButterKnife.inject(this, view);
        switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_grey));
        switchDisplay.setContentDescription("OFF");
        return view;
    }

    /**
     * Switches the frame's background color
     *
     * @param view
     */
    @OnClick(R.id.input_switch)
    public void onToggleClicked(View view){
        if (((SwitchCompat)view).isChecked()) {
            switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_yellow));
            switchDisplay.setContentDescription("ON");
        } else {
            switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_grey));
            switchDisplay.setContentDescription("OFF");
        }
    }
}
