package com.nelusion.astraclient.service;

import com.nelusion.astraclient.combat.CombatModeService;
import com.nelusion.astraclient.logging.LoggerService;
import com.nelusion.astraclient.module.ModuleService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ServiceContainer {

    private final Map<Class<? extends Service>, Service> services = new HashMap<>();

    public void registerDefaults() {
        register(new LoggerService());

        CombatModeService combatModeService = new CombatModeService();
        register(combatModeService);

        register(new ModuleService(combatModeService));
    }

    public <T extends Service> void register(T service) {
        services.put(service.getClass(), service);
    }

    public void initialize() {
        for (Service service : services.values()) {
            service.initialize();
        }
    }

    public void shutdown() {
        for (Service service : services.values()) {
            service.shutdown();
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Service> T get(Class<T> type) {
        return (T) services.get(type);
    }

    public Collection<Service> all() {
        return services.values();
    }
}
