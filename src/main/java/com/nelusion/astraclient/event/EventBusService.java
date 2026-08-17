package com.nelusion.astraclient.event;

import com.nelusion.astraclient.service.Service;
import com.nelusion.astraclient.test.TickTestListener;

public final class EventBusService implements Service {

    @Override
    public void initialize() {
        System.out.println("[Astra] EventBus initialized");

        EventBus.register(new TickTestListener());
    }

    @Override
    public void shutdown() {
        System.out.println("[Astra] EventBus shutdown");
    }
}
