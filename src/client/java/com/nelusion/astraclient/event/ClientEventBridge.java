package com.nelusion.astraclient.event;

import com.nelusion.astraclient.event.impl.TickEvent;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public final class ClientEventBridge {

    private ClientEventBridge() {
    }

    public static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client ->
                EventBus.post(new TickEvent(true))
        );
    }
}
