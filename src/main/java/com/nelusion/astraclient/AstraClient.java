package com.nelusion.astraclient;

import com.nelusion.astraclient.core.ClientBootstrap;
import net.fabricmc.api.ModInitializer;

public class AstraClient implements ModInitializer {

    public static final String NAME = "Astra Client";
    public static final String VERSION = "1.0.0";

    @Override
    public void onInitialize() {
        ClientBootstrap.initialize();
    }
}
