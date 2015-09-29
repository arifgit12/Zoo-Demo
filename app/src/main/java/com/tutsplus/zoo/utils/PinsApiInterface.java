package com.tutsplus.zoo.utils;

import com.tutsplus.zoo.models.Pin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by dreamer on 28-09-2015.
 */
public interface PinsApiInterface {

    @GET("/Pins.json")
    void getStreams( Callback<List<Pin>> callback );
}
