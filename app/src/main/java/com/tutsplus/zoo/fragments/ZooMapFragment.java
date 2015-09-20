package com.tutsplus.zoo.fragments;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by dreamer on 20-09-2015.
 */
public class ZooMapFragment extends SupportMapFragment {
    public static ZooMapFragment getInstance() {
        ZooMapFragment fragment = new ZooMapFragment();

        return fragment;
    }
}
