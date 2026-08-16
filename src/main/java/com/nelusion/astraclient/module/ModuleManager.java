package com.nelusion.astraclient.module;

import com.nelusion.astraclient.combat.CombatMode;
import com.nelusion.astraclient.service.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModuleManager implements Service {

    private final List<Module> modules = new ArrayList<>();

    public void register(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public List<Module> getAvailableModules(CombatMode mode) {
        return modules.stream()
                .filter(module -> module.supportedModes().contains(mode))
                .toList();
    }

    public Module getModule(String name) {
        return modules.stream()
                .filter(module -> module.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void shutdown() {
        modules.clear();
    }
}
