package net.mysterymod.example.addon.modules;

import net.mysterymod.api.module.category.ModuleCategory;
import net.mysterymod.example.addon.modules.ExampleModule;

public final class ExampleAddonCategory {
  public static final ModuleCategory MODULE_CATEGORY = ModuleCategory.create(
    "Example Modules",
    ExampleModule.class
  );
}
