package com.nelusion.astraclient.module.impl.combat;

import com.nelusion.astraclient.combat.CombatMode;
import com.nelusion.astraclient.module.Module;
import com.nelusion.astraclient.module.ModuleCategory;

import java.util.EnumSet;

public final class BlockHitModule extends Module {

    public BlockHitModule() {
        super("Block Hit", ModuleCategory.COMBAT);
    }

    @Override
    public EnumSet<CombatMode> supportedModes() {
        return EnumSet.of(CombatMode.ONE_EIGHT);
    }
}
