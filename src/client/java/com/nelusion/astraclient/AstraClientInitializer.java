package com.nelusion.astraclient;

import com.nelusion.astraclient.event.ClientEventBridge;
import net.fabricmc.api.ClientModInitializer;

public final class AstraClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientEventBridge.initialize();

        System.out.println("[Astra] Client initializer initialized");
    }
}
