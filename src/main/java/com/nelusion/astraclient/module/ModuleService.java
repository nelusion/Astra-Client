package com.nelusion.astraclient.module;

import com.nelusion.astraclient.combat.CombatMode;
import com.nelusion.astraclient.module.impl.combat.BlockHitModule;
import com.nelusion.astraclient.service.Service;

public final class ModuleService implements Service {

    private final ModuleManager manager = new ModuleManager();

    public ModuleManager getManager() {
        return manager;
    }

    @Override
    public void initialize() {
        manager.register(new BlockHitModule());

        manager.setActiveMode(CombatMode.ONE_NINE_PLUS);

        System.out.println("[Astra] ModuleService initialized");

        for (Module module : manager.getModules()) {
            System.out.println(
                    "[Astra] Loaded module: "
                            + module.getName()
                            + " | Available: "
                            + manager.isAvailable(module)
            );
        }
    }

    @Override
    public void shutdown() {
        manager.shutdown();
    }
}
