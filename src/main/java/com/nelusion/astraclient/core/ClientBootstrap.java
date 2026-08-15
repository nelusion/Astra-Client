package com.nelusion.astraclient.core;

import com.nelusion.astraclient.Astra;

public final class ClientBootstrap {

    private static boolean initialized = false;

    private ClientBootstrap() {
    }

    public static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;

        Astra.services().initialize();
    }
}
