package com.nelusion.astraclient;

import net.fabricmc.api.ClientModInitializer;

public class AstraClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println(AstraClient.NAME + " client initialized.");
    }
}
