package com.qualifylabs.devicelab.android.referenceapp.Fragments.Tabs.Native;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.qualifylabs.devicelab.android.referenceapp.Adapters.ImageGalleryAdapter;
import com.qualifylabs.devicelab.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment that demonstrates a root image gallery view
 */
public class Native_ImageGalleryFragment extends Fragment {
    @InjectView(R.id.native_image_grid_view)
    GridView imageGalley;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.native_imagegallery_fragment, container, false);
        ButterKnife.inject(this, view);
        imageGalley.setAdapter(new ImageGalleryAdapter(getActivity()));
        return view;
    }
}
