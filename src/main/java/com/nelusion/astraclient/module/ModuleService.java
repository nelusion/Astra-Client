package com.nelusion.astraclient.module;

import com.nelusion.astraclient.service.Service;

public final class ModuleService implements Service {

    private final ModuleManager manager = new ModuleManager();

    public ModuleManager manager() {
        return manager;
    }

    @Override
    public void initialize() {
        manager.initialize();
    }

    @Override
    public void shutdown() {
        manager.shutdown();
    }
}
