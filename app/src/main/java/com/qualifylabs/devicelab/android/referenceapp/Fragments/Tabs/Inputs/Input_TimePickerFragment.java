package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating a time picker input
 */
public class Input_TimePickerFragment extends Fragment  implements TimePicker.OnTimeChangedListener{
    @InjectView(R.id.input_timepicker)
    TimePicker timePicker;

    @InjectView(R.id.input_time_display)
    TextView timeDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_timepicker_fragment, container, false);
        ButterKnife.inject(this,view);
        timePicker.setOnTimeChangedListener(this);
        timeDisplay.setText(getString(R.string.time_picker_default_display));
        return view;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        timeDisplay.setText(String.format("%d : %02d", hourOfDay, minute));
    }
}
