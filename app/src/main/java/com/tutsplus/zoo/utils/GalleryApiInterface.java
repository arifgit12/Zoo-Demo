package com.tutsplus.zoo.utils;

import com.tutsplus.zoo.models.GalleryImage;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by dreamer on 25-09-2015.
 */
public interface GalleryApiInterface {

    @GET( "/gallery.json" )
    void getStreams( Callback<List<GalleryImage>> callback );
}
