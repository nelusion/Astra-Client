package com.nelusion.astraclient.event;

import com.nelusion.astraclient.event.impl.UpdateEvent;
import com.nelusion.astraclient.service.Service;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public final class ClientEventService implements Service {

    @Override
    public void initialize() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            EventBus.post(new UpdateEvent());
        });

        System.out.println("[Astra] Client events initialized");
    }

    @Override
    public void shutdown() {
        System.out.println("[Astra] Client events shutdown");
    }
}
