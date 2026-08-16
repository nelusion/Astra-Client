package com.nelusion.astraclient.module;

public enum ModuleCategory {

    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    RENDER("Render"),
    VISUAL("Visual"),
    WORLD("World"),
    MISC("Misc"),
    UTILITY("Utility");

    private final String displayName;

    ModuleCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
