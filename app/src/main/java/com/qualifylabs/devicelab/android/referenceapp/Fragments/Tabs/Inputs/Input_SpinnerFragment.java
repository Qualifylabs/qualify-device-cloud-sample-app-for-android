package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment representing a spinner input
 */
public class Input_SpinnerFragment extends Fragment implements Spinner.OnItemSelectedListener{
    @InjectView(R.id.input_spinner)
    Spinner spinner;

    @InjectView(R.id.input_spinner_message)
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_spinner_fragment, container, false);
        ButterKnife.inject(this, view);
        spinnerAdapter();
        spinner.setOnItemSelectedListener(this);
        return view;
    }

    public void spinnerAdapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinner_array));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = String.valueOf(spinner.getItemAtPosition(position));
        textView.setText(String.format(getString(R.string.spinner_display), message));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
