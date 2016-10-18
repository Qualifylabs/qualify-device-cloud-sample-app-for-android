package com.qualifylabs.devicelab.android.referenceapp.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qualifylabs.devicelab.android.referenceapp.Models.FragmentEnum;
import com.qualifylabs.devicelab.android.referenceapp.Models.TabViewModel;

import java.util.List;

/**
 * An adapter for the pageview
 */
public class TabAdapter extends FragmentPagerAdapter {

    List<TabViewModel> tabs;
    public TabAdapter(FragmentManager fragmentManager, List<TabViewModel> tabs){
        super(fragmentManager);
        this.tabs = tabs;
    }

    /**
     * Gets the fragment for a specific tab
     * @param position
     * @return the fragment for a specific position
     */
    @Override
    public Fragment getItem(int position) {
        return FragmentEnum.valueOf(tabs.get(position).getTab_id()).getFragment();
    }

    /**
     * Gets the number of tabs
     * @return tab size
     */
    @Override
    public int getCount() {
        return tabs.size();
    }

    /**
     * Gets the title for a tab at a specific position
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTab_name();
    }
}
