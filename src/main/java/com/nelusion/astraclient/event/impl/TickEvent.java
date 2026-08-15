package com.nelusion.astraclient.event.impl;

import com.nelusion.astraclient.event.Event;

public class TickEvent extends Event {

    private final boolean clientTick;

    public TickEvent(boolean clientTick) {
        this.clientTick = clientTick;
    }

    public boolean isClientTick() {
        return clientTick;
    }
}
