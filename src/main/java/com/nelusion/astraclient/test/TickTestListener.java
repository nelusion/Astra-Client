package com.nelusion.astraclient.test;

import com.nelusion.astraclient.event.EventListener;
import com.nelusion.astraclient.event.impl.TickEvent;

public final class TickTestListener implements EventListener<TickEvent> {

    @Override
    public void onEvent(TickEvent event) {
        System.out.println("[Astra] Tick event received");
    }
}
