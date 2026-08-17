package com.nelusion.astraclient.event;

import com.nelusion.astraclient.service.Service;

public final class EventBusService implements Service {

    @Override
    public void initialize() {
        System.out.println("[Astra] EventBus initialized");
    }

    @Override
    public void shutdown() {
        System.out.println("[Astra] EventBus shutdown");
    }
}
