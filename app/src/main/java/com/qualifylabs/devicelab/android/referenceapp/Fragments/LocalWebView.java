package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class LocalWebView extends Fragment {

    @InjectView(R.id.website_input)
    EditText websiteInput;

    @InjectView(R.id.webView_browser)
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_fragment, container, false);
        ButterKnife.inject(this, view);
        websiteInput.setVisibility(View.GONE);
        setUpWebView();
        return view;
    }

    /**
     * Sets up a web view
     */
    private void setUpWebView(){
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl(getString(R.string.local_web_view_url));
    }
}
