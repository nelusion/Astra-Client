package com.nelusion.astraclient.combat;

public enum CombatMode {

    ONE_EIGHT("1.8 PvP"),
    ONE_NINE_PLUS("1.9+ PvP");

    private final String displayName;

    CombatMode(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
