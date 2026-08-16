package com.nelusion.astraclient.module;

import com.nelusion.astraclient.combat.CombatMode;
import com.nelusion.astraclient.combat.CombatModeService;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {

    private final List<Module> modules = new ArrayList<>();
    private final CombatModeService combatModeService;

    public ModuleManager(CombatModeService combatModeService) {
        this.combatModeService = combatModeService;
    }

    public void register(Module module) {
        modules.add(module);
    }

    public void initialize() {
        refreshModules();
    }

    public void refreshModules() {
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
        return module.supportedModes().contains(combatModeService.getCurrentMode());
    }

    public CombatMode getActiveMode() {
        return combatModeService.getCurrentMode();
    }

    public void setActiveMode(CombatMode mode) {
        combatModeService.setCurrentMode(mode);
        refreshModules();
    }

    public void shutdown() {
        modules.clear();
    }
}
