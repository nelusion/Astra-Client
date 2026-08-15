package com.nelusion.astraclient.event;

import com.nelusion.astraclient.core.Service;

public final class EventService implements Service {

    private static EventService instance;

    public static EventService getInstance() {
        if (instance == null) {
            instance = new EventService();
        }

        return instance;
    }

    private EventService() {
    }

    @Override
    public void initialize() {
        instance = this;
    }

    @Override
    public void shutdown() {
        instance = null;
    }
}
