package com.nelusion.astraclient.module;

import com.nelusion.astraclient.module.impl.combat.BlockHitModule;
import com.nelusion.astraclient.service.Service;

public final class ModuleService implements Service {

    private final ModuleManager manager = new ModuleManager();

    public ModuleManager manager() {
        return manager;
    }

    @Override
    public void initialize() {
        manager.register(new BlockHitModule());

        manager.initialize();

        System.out.println("[Astra] Module service initialized");

        for (Module module : manager.getModules()) {
            System.out.println(
                    "[Astra] Module: "
                            + module.getName()
                            + " | Modes: "
                            + module.supportedModes()
            );
        }
    }

    @Override
    public void shutdown() {
        manager.shutdown();
    }
}
