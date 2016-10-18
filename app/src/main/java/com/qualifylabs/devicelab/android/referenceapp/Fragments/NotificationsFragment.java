package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
 * A fragment used to demonstrate notications
 */
public class NotificationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * Toast button clicked; shows toast
     */
    @OnClick(R.id.notifications_toast_button)
    public void onToastButtonClick(){
        Toast.makeText(getActivity(), getString(R.string.Toast_button_message), Toast.LENGTH_SHORT).show();

    }

    /**
     * Alert button clicked; shows alert
     */
    @OnClick(R.id.notifications_alert_button)
    public void onAlertButton(){
        new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.alert_title)).
                setMessage(getString(R.string.alert_message)).setPositiveButton(getString(R.string.alert_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();

    }
}
