package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.SupplementalUploads;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qualifylabs.devicelab.android.referenceapp.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Fragment that displays the directory where users' extra data is uploaded.
 */
public class SupplementalUploads_ExtraDataFragment extends ListFragment {
    private static final String EXTRA_DATA_PATH = "/sdcard/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.supplemental_uploads_extra_data_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, getDirectoryContents(EXTRA_DATA_PATH)) {
            // Set text color to black
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView row = (TextView) super.getView(position, convertView, parent);
                row.setTextColor(Color.BLACK);
                return row;
            }
        };

        setListAdapter(arrayAdapter);
    }

    /**
     * Retrieve the directory contents as an ArrayList of filenames.
     *
     * @param path
     * @return ArrayList
     */
    private ArrayList<String> getDirectoryContents(String path) {
        File file = new File(path);
        return new ArrayList<>(Arrays.asList(file.list()));
    }
}
