package com.nelusion.astraclient.event.impl;

import com.nelusion.astraclient.event.Event;

public class InputEvent extends Event {

    public enum Type {
        KEYBOARD,
        MOUSE
    }

    private final Type type;
    private final int key;
    private final int action;

    public InputEvent(Type type, int key, int action) {
        this.type = type;
        this.key = key;
        this.action = action;
    }

    public Type getType() {
        return type;
    }

    public int getKey() {
        return key;
    }

    public int getAction() {
        return action;
    }
}
