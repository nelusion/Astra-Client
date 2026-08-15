package com.nelusion.astraclient.logging;

import com.nelusion.astraclient.service.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LoggerService implements Service {

    private final Map<String, AstraLogger> loggers = new ConcurrentHashMap<>();

    public AstraLogger getLogger(String name) {
        return loggers.computeIfAbsent(
                name,
                AstraLogger::new
        );
    }

    @Override
    public void initialize() {
        getLogger("Astra").info("Logger service initialized");
    }

    @Override
    public void shutdown() {
        loggers.clear();
    }
}
