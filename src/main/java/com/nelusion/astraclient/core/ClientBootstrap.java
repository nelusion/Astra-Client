package com.nelusion.astraclient.core;

public final class ClientBootstrap {

    private static boolean initialized = false;

    private ClientBootstrap() {
    }

    public static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;

        ServiceRegistry.initialize();
    }
}
