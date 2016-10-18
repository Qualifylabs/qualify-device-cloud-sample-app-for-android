package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating radio button input
 */
public class Input_RadioButtonFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    @InjectView(R.id.radio_button_group)
    RadioGroup radioGroup;

    @InjectView(R.id.input_radio_button_display)
    TextView radioButtonDisplay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_radio_button_fragment, container, false);
        ButterKnife.inject(this,view);
        radioGroup.setOnCheckedChangeListener(this);
        radioButtonDisplay.setText(getString(R.string.radio_button_1));
        return view;
    }

    /**
     * When a radio button is selected
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        setDisplay(checkedId);
    }

    /**
     * Changes display based upon the given radio button id
     * @param radio_id
     */
    private void setDisplay(int radio_id){
        RadioButton radioButton = (RadioButton) getActivity().findViewById(radio_id);
        radioButtonDisplay.setText(radioButton.getText());
    }
}
