package com.qualifylabs.devicelab.android.referenceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qualifylabs.devicelab.android.referenceapp.Adapters.TabAdapter;
import com.qualifylabs.devicelab.android.referenceapp.Models.TabViewModel;
import com.qualifylabs.devicelab.android.referenceapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment container for fragments with tabs
 * Uses a page view for tab switching
 */
public class TabFragmentContainer extends Fragment {

    @InjectView(R.id.view_pager1)
    ViewPager pager;

    public TabFragmentContainer() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {//TODO SINGLETON or single instance?
        View view =  inflater.inflate(R.layout.tab_fragment_container, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        List<TabViewModel> data = args.getParcelableArrayList(getString(R.string.tab_fragment_bundle_key));
        setUp(data);
    }

    private void setUp(List<TabViewModel> dataModel){
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), dataModel);
        pager.setAdapter(tabAdapter);
    }
}
