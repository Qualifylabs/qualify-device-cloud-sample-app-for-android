package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Fragment which represents datepicker input
 */
public class Input_DatePickerFragment extends Fragment implements DatePicker.OnDateChangedListener{
    @InjectView(R.id.input_datepicker)
    DatePicker datePicker;

    @InjectView(R.id.input_date_display)
    TextView timeDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_datepicker_fragment, container, false);
        ButterKnife.inject(this,view);
        datePicker.init(1994,6,5,this);
        changeDisplay(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
        return view;
    }

    /**
     * Event when date picker is changed
     * @param view
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     */
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        changeDisplay(year,monthOfYear,dayOfMonth);
    }

    /**
     * changes the date display
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     */
    private void changeDisplay(int year, int monthOfYear, int dayOfMonth) {
        timeDisplay.setText(String.format("%d/%d/%d", ++monthOfYear, dayOfMonth, year));
    }
}
