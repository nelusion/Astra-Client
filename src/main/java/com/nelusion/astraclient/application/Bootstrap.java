package com.nelusion.astraclient.application;

import com.nelusion.astraclient.Astra;

public final class Bootstrap {

    private static boolean initialized = false;

    private Bootstrap() {
    }

    public static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;

        Astra.services().registerDefaults();
        Astra.services().initialize();
    }
}
