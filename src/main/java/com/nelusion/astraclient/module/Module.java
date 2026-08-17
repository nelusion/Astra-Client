package com.nelusion.astraclient.module;

import com.nelusion.astraclient.combat.CombatMode;
import com.nelusion.astraclient.event.Event;
import com.nelusion.astraclient.event.EventBus;
import com.nelusion.astraclient.event.EventListener;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class Module {

    private final String name;
    private final ModuleCategory category;

    private final List<ListenerRegistration<?>> listeners = new ArrayList<>();

    private boolean enabled;

    protected Module(String name, ModuleCategory category) {
        this.name = name;
        this.category = category;
    }

    public abstract EnumSet<CombatMode> supportedModes();

    public String getName() {
        return name;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) {
            return;
        }

        this.enabled = enabled;

        if (enabled) {
            onEnable();
        } else {
            unregisterListeners();
            onDisable();
        }
    }

    protected void onEnable() {
    }

    protected void onDisable() {
    }

    protected <T extends Event> void listen(Class<T> eventClass, EventListener<T> listener) {
        EventBus.register(eventClass, listener);
        listeners.add(new ListenerRegistration<>(eventClass, listener));
    }

    private void unregisterListeners() {
        for (ListenerRegistration<?> registration : listeners) {
            registration.unregister();
        }

        listeners.clear();
    }

    private record ListenerRegistration<T extends Event>(
            Class<T> eventClass,
            EventListener<T> listener
    ) {

        void unregister() {
            EventBus.unregister(eventClass, listener);
        }
    }
}
