package com.nelusion.astraclient;

import com.nelusion.astraclient.application.Bootstrap;
import com.nelusion.astraclient.event.ClientEventBridge;
import net.fabricmc.api.ClientModInitializer;

public class AstraClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Bootstrap.initialize();
        ClientEventBridge.initialize();
    }
}
