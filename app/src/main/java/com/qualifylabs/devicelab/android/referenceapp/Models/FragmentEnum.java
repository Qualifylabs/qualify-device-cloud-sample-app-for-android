package com.qualifylabs.devicelab.android.referenceapp.Models;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qualifylabs.devicelab.android.referenceapp.Fragments.FixturesFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.LocalWebView;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.LoginFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.NestedFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.NotificationsFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.SimpleFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_CheckBoxFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_DatePickerFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_GestureFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_RadioButtonFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_RefreshButtonFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_SpinnerFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_SubmitButtonFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_TimePickerFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Inputs.Input_Toggle_ButtonFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Native.Native_CameraFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Native.Native_ImageGalleryFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Native.Native_MediaPlayer;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.SupplementalUploads.SupplementalUploads_AdditionalAppFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.SupplementalUploads.SupplementalUploads_ExtraDataFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.WebViewFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.crashFragment;
import com.qualifylabs.devicelab.android.referenceapp.R;

/**
 * An Enum representing all the fragments within the app
 */
public enum FragmentEnum {
    HOME(createSimpleFragment(R.layout.fragment_homepage)),
    HTTP(new WebViewFragment()),
    NATIVE(null),
    INPUTS(null),
    NESTED(new NestedFragment()),
    CRASH(new crashFragment()),
    ALERT(new NotificationsFragment()),
    LOGIN(new LoginFragment()),

    //tabs for input
    EDIT_TEXT(createSimpleFragment(R.layout.input_textfield)),
    CHECKBOX(new Input_CheckBoxFragment()),
    RADIO_BUTTON(new Input_RadioButtonFragment()),
    TOGGLE_BUTTON(new Input_Toggle_ButtonFragment()),
    TIME_PICKER(new Input_TimePickerFragment()),
    DATE_PICKER(new Input_DatePickerFragment()),
    SUBMIT_BUTTON(new Input_SubmitButtonFragment()),
    REFRESH(new Input_RefreshButtonFragment()),
    SPINNER(new Input_SpinnerFragment()),
    GESTURES(new Input_GestureFragment()),

    //tabs for native views
    IMAGE_GALLERY(new Native_ImageGalleryFragment()),
    CONTENT_SCROLLING(createSimpleFragment(R.layout.native_content_scrolling)),
    MEDIA_PLAYER(new Native_MediaPlayer()),
    CAMERA(new Native_CameraFragment()),
    OUT_OF_VIEW(createSimpleFragment(R.layout.native_out_of_view_scrolling)),
    FIXTURES(new FixturesFragment()),
    LOCAL_WEB_VIEW(new LocalWebView()),

    //tabs for supplemental uploads
    SUPPLEMENTAL_UPLOADS(null),
    EXTRA_DATA(new SupplementalUploads_ExtraDataFragment()),
    ADDITIONAL_APP(new SupplementalUploads_AdditionalAppFragment());

    private final Fragment fragment;

    FragmentEnum(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment(){
        return this.fragment;
    }

    /**
     * Creates a static fragment with no logic from a layout
     * @param resourceLayoutId
     * @return
     */
    private static Fragment createSimpleFragment(int resourceLayoutId){
        Fragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("frag_bundle_key", resourceLayoutId);
        fragment.setArguments(bundle);
        return fragment;
    }
}
