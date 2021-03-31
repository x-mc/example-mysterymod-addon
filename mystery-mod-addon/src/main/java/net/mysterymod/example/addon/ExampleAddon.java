package net.mysterymod.example.addon;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;
import net.mysterymod.api.event.EventHandler;
import net.mysterymod.api.event.game.GameTickEvent;
import net.mysterymod.api.listener.ListenerChannel;
import net.mysterymod.api.module.ModuleRegistry;
import net.mysterymod.api.module.category.ModuleCategoryRegistry;
import net.mysterymod.example.addon.ingame.IIngameTitle;
import net.mysterymod.example.addon.modules.ExampleAddonCategory;
import net.mysterymod.example.addon.settings.ExampleAddonSettingsConfig;
import net.mysterymod.example.addon.settings.ExampleAddonSettingsProvider;
import net.mysterymod.mod.addon.Addon;
import net.mysterymod.mod.addon.EnableInitListeners;

import java.util.logging.Logger;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
@EnableInitListeners("net.mysterymod.example.addon")
public class ExampleAddon extends Addon {
  private final Logger logger;
  private final Injector injector;
  private final ModuleCategoryRegistry categoryRegistry;
  private final ModuleRegistry moduleRegistry;
  private final ListenerChannel listenerChannel;
  private final ExampleAddonSettingsConfig settingsConfig;
  private final ExampleAddonSettingsProvider settingsProvider;

  private IIngameTitle ingameTitle;

  private boolean shouldBeDisplayTitle;

  @Override
  public void onEnable() {
    logger.info("Hello World from example-addon!");
    listenerChannel.registerListener(this);

    setSettingsProvider(settingsProvider);

    registerModules();

    shouldBeDisplayTitle = true;

    Injector childInjector = createExampleChildInjector();
    this.ingameTitle = childInjector.getInstance(IIngameTitle.class);
  }

  private void registerModules() {
    categoryRegistry.registerModuleCategory(ExampleAddonCategory.MODULE_CATEGORY);
    moduleRegistry.registerAddonModules(this, "net.mysterymod.example.addon", true);
  }

  private Injector createExampleChildInjector() {
    return injector.createChildInjector(ExampleAddonChildInjectModule.create());
  }

  @EventHandler
  public void configureDisplayState(GameTickEvent event) {
    if (!settingsConfig.enabled()) {
      return;
    }

    if (event.isIngame()) {
      if (shouldBeDisplayTitle) {
        ingameTitle.display("Hello!");
        shouldBeDisplayTitle = false;
      }
    } else {
      shouldBeDisplayTitle = true;
    }
  }
}
