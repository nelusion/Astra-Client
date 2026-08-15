package com.nelusion.astraclient.logging;

public final class AstraLogger {

    private final String name;

    public AstraLogger(String name) {
        this.name = name;
    }

    public void log(LogLevel level, String message) {
        System.out.println(
                "[" + level.name() + "] "
                        + "[" + name + "] "
                        + message
        );
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
}
