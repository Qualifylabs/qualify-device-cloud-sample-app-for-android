package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.Adapters.GestureListener;
import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Fragment demonstrating a touch inputs
 */
public class Input_GestureFragment extends Fragment{
    @InjectView(R.id.input_gesture_action_pad)
    FrameLayout actionPad;

    @InjectView(R.id.input_gesture_content)
    TextView gestureContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_gesture_fragment, container, false);
        ButterKnife.inject(this, view);
        actionPad.setClickable(true);
        actionPad.setFocusable(true);

        GestureDetector.SimpleOnGestureListener gestureListener = new GestureListener(gestureContent, getActivity());
        final GestureDetector gd = new GestureDetector(getActivity(), gestureListener);

        actionPad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gd.onTouchEvent(motionEvent);
                return false;
            }
        });
        return view;
    }
}
