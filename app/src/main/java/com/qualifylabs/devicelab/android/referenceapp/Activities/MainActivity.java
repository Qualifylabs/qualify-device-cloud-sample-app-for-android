package com.qualifylabs.devicelab.android.referenceapp.Activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.Adapters.DrawerAdapter;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.NavigationDrawerFragment;
import com.qualifylabs.devicelab.android.referenceapp.Fragments.TabFragmentContainer;
import com.qualifylabs.devicelab.android.referenceapp.Models.DrawerCategoryModel;
import com.qualifylabs.devicelab.android.referenceapp.Models.FragmentEnum;
import com.qualifylabs.devicelab.android.referenceapp.R;
import com.qualifylabs.devicelab.android.referenceapp.Util.JsonParser;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * <h1>Main acitivity</h1>
 *
 * <p>
 *     This acitivty holds the navigation drawer
 *     and all of the navigation fragments.
 * </p>
 */
public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemClickListener{
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.toolbar_title)
    TextView toolbarTitle;

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    /**
     * A list representing the JSON Drawer Rows
     */
    private List<DrawerCategoryModel> data;

    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        generateDataModel();
        setUpToolBar();
        setUpNavigationDrawer();

        //Displays the first drawer row
        displayFragment(0);
    }

    /**
     * Sets the toolbar as the actionbar
     */
    private void setUpToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    /**
     * Initializes the navigation drawer
     */
    private void setUpNavigationDrawer(){
        NavigationDrawerFragment navigationFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer_fragment);
        navigationFragment.setUp(R.id.navigation_drawer_fragment, drawerLayout, data, toolbar, this);
    }

    /**
     * Parses the JSON file representing the drawer rows and tabs
     */
    private void generateDataModel(){
        JsonParser parser = new JsonParser(this, R.raw.fragments);
        data = parser.serializeJson();
    }


    /**
     * Changes the fragment when clicked
     */
    @Override
    public void onNavMenuItemClick(final View view, final int position) {
        displayFragment(position);
    }

    /**
     * Displays a specific fragment from a specific position in the drawer list
     * @param position
     */
    private void displayFragment(int position) {
        Fragment newFragment;
        //Checks if the fragment has tabs associated with it.
        if (!data.get(position).isHas_tabs()) {
            newFragment = FragmentEnum.valueOf(data.get(position).getFragment_id()).getFragment();
        } else {
            newFragment = new TabFragmentContainer();
            Bundle args = new Bundle();
            args.putParcelableArrayList(getString(R.string.tab_fragment_bundle_key),
                    (ArrayList<? extends Parcelable>) data.get(position).getTabs());
            newFragment.setArguments(args);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, newFragment);
        fragmentTransaction.commit();

        toolbarTitle.setText(data.get(position).getHeadline());
    }

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }
}
