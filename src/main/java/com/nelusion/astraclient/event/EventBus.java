package com.nelusion.astraclient.event;

import java.util.ArrayList;
import java.util.List;

public final class EventBus {

    private static final List<ListenerEntry<?>> LISTENERS = new ArrayList<>();

    private EventBus() {
    }

    public static <T extends Event> void register(Class<T> eventClass, EventListener<T> listener) {
        LISTENERS.add(new ListenerEntry<>(eventClass, listener));
    }

    public static <T extends Event> void unregister(Class<T> eventClass, EventListener<T> listener) {
        LISTENERS.removeIf(entry ->
                entry.eventClass.equals(eventClass)
                        && entry.listener.equals(listener)
        );
    }

    public static void post(Event event) {
        for (ListenerEntry<?> entry : List.copyOf(LISTENERS)) {
            entry.invoke(event);
        }
    }

    private record ListenerEntry<T extends Event>(
            Class<T> eventClass,
            EventListener<T> listener
    ) {

        @SuppressWarnings("unchecked")
        void invoke(Event event) {
            if (eventClass.isInstance(event)) {
                ((EventListener<Event>) listener).onEvent(event);
            }
        }
    }
}
