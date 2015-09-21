package com.tutsplus.zoo.utils;

import com.tutsplus.zoo.models.Animal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by dreamer on 21-09-2015.
 */
public interface AnimalApiInterface {
    @GET("/Exhibits.json")
    void getStreams( Callback<List<Animal>> callback);
}
