package com.nelusion.astraclient;

import com.nelusion.astraclient.service.ServiceContainer;

public final class Astra {

    private static final ServiceContainer SERVICES = new ServiceContainer();

    private Astra() {
    }

    public static ServiceContainer services() {
        return SERVICES;
    }
}
