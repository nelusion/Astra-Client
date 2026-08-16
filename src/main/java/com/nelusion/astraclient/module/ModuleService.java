@Override
public void initialize() {
    manager.register(new BlockHitModule());

    manager.setActiveMode(
            com.nelusion.astraclient.combat.CombatMode.ONE_NINE_PLUS
    );

    System.out.println("[Astra] ModuleService initialized");

    for (Module module : manager.getModules()) {
        System.out.println(
                "[Astra] Loaded module: "
                        + module.getName()
                        + " | Available: "
                        + manager.isAvailable(module)
        );
    }
}
