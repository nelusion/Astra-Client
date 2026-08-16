package com.nelusion.astraclient.module;

import com.nelusion.astraclient.combat.CombatMode;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    private CombatMode activeMode = CombatMode.ONE_EIGHT;

    public void register(Module module) {
        modules.add(module);
    }

    public void initialize() {
        for (Module module : modules) {
            if (!isAvailable(module)) {
                module.setEnabled(false);
            }
        }
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getAvailableModules() {
        return modules.stream()
                .filter(this::isAvailable)
                .toList();
    }

    public boolean isAvailable(Module module) {
        return module.supportedModes().contains(activeMode);
    }

    public void setActiveMode(CombatMode mode) {
        this.activeMode = mode;

        for (Module module : modules) {
            if (!isAvailable(module)) {
                module.setEnabled(false);
            }
        }

        System.out.println(
                "[Astra] PvP mode switched to: " + mode
        );
    }

    public CombatMode getActiveMode() {
        return activeMode;
    }

    public void shutdown() {
        modules.clear();
    }
}
