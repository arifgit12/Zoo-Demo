package com.tutsplus.zoo.utils;

import com.squareup.otto.Bus;

/**
 * Created by dreamer on 20-09-2015.
 */
public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();

    public static Bus getInstance(){
        return bus;
    }

    private EventBus(){

    }
}
