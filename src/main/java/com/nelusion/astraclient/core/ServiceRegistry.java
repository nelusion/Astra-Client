package com.nelusion.astraclient.core;

import java.util.ArrayList;
import java.util.List;

public final class ServiceRegistry {

    private static final List<Service> SERVICES = new ArrayList<>();

    private ServiceRegistry() {
    }

    public static void register(Service service) {
        SERVICES.add(service);
    }

    public static void initialize() {
        for (Service service : SERVICES) {
            service.initialize();
        }
    }

    public static void shutdown() {
        for (Service service : SERVICES) {
            service.shutdown();
        }
    }

    public static List<Service> getServices() {
        return List.copyOf(SERVICES);
    }
}
