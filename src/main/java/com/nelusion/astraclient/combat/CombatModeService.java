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

        this.currentMode = mode;
    }
}
