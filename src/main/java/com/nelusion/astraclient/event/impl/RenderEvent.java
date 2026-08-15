package com.nelusion.astraclient.event.impl;

import com.nelusion.astraclient.event.Event;

public class RenderEvent extends Event {

    public enum Type {
        TWO_D,
        THREE_D
    }

    private final Type type;

    public RenderEvent(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
