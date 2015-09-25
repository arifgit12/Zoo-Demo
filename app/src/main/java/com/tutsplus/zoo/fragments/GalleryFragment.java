package com.tutsplus.zoo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tutsplus.zoo.R;
import com.tutsplus.zoo.adapters.GalleryImageAdapter;
import com.tutsplus.zoo.models.GalleryImage;
import com.tutsplus.zoo.utils.GalleryApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by dreamer on 20-09-2015.
 */
public class GalleryFragment extends Fragment {

    private GridView mGridView;
    private GalleryImageAdapter mAdapter;

    public static  GalleryFragment getInstance(){
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_gallery_grid, container, false );
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mGridView = (GridView) view.findViewById( R.id.grid );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mAdapter = new GalleryImageAdapter(getActivity(), 0);
        mGridView.setAdapter( mAdapter );

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.gallery_feed))
                .build();

        GalleryApiInterface galleryApiInterface = restAdapter.create(GalleryApiInterface.class);

        galleryApiInterface.getStreams(new Callback<List<GalleryImage>>() {
            @Override
            public void success(List<GalleryImage> galleryImages, Response response) {
                if (galleryImages == null || galleryImages.isEmpty())
                    return;

                for( GalleryImage image : galleryImages ) {
                    Log.e("Zoo", image.getThumbnail());
                    mAdapter.add(image);
                }

                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
