package com.nelusion.astraclient.core;

import java.util.ArrayList;
import java.util.List;

public final class ServiceRegistry {

    private static final List<Object> SERVICES = new ArrayList<>();

    private ServiceRegistry() {
    }

    public static void register(Object service) {
        SERVICES.add(service);
    }

    public static List<Object> getServices() {
        return List.copyOf(SERVICES);
    }

    public static void initialize() {
        for (Object service : SERVICES) {
            if (service instanceof Initializable initializable) {
                initializable.initialize();
            }
        }
    }

    public interface Initializable {
        void initialize();
    }
}
