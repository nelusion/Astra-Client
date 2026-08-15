package com.nelusion.astraclient;

import com.nelusion.astraclient.event.ClientEventBridge;
import com.nelusion.astraclient.core.ClientBootstrap;
import net.fabricmc.api.ClientModInitializer;

public class AstraClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientBootstrap.initialize();
        ClientEventBridge.initialize();
    }
}
