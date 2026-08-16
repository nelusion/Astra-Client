package com.nelusion.astraclient.combat;

import com.nelusion.astraclient.service.Service;

public final class CombatModeService implements Service {

    private CombatMode currentMode = CombatMode.ONE_EIGHT;

    public CombatMode getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(CombatMode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("Combat mode must not be null.");
        }

        if (currentMode == mode) {
            return;
        }

        currentMode = mode;

        System.out.println("[Astra] PvP mode switched to: " + mode.getDisplayName());
    }

    public boolean isOneEight() {
        return currentMode == CombatMode.ONE_EIGHT;
    }

    public boolean isOneNinePlus() {
        return currentMode == CombatMode.ONE_NINE_PLUS;
    }

    @Override
    public void initialize() {
        System.out.println("[Astra] Combat mode initialized: " + currentMode.getDisplayName());
    }
}
