package com.qualifylabs.devicelab.android.referenceapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * <h1>Up Navigation Content Activity</h1>
 * <p>
 *     The content for the up navigation demonstration
 * </p>
 */
public class UpNavigationContent extends AppCompatActivity{
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.nested_up_button)
    Button nextButton;

    @InjectView(R.id.toolbar_title)
    TextView toolbarTitle;

    @InjectView(R.id.up_navigation_content_text)
    TextView content_text;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.up_navigation);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(R.string.up_navigation_final);
        content_text.setText(R.string.up_navigation_final);
        nextButton.setVisibility(View.GONE);
    }

    @Override
    /**
     * Support for the back button
     */
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getApplication(), UpNavigationActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            NavUtils.navigateUpTo(this, intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
