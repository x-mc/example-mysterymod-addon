package net.mysterymod.example.addon.settings;

import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;
import net.mysterymod.mod.addon.AddonSettingsProvider;
import net.mysterymod.mod.gui.settings.SettingsGui;
import net.mysterymod.mod.gui.settings.component.SettingsComponent;
import net.mysterymod.mod.gui.settings.component.SettingsComponentProvider;
import net.mysterymod.mod.gui.settings.component.toggle.ToggleComponent;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public final class ExampleAddonSettingsProvider implements AddonSettingsProvider {
  private final ExampleAddonSettingsConfig settingsConfig;

  @Override
  public void addSettings(
    SettingsGui settingsGui,
    SettingsComponentProvider settingsComponentProvider,
    List<SettingsComponent> components
  ) {
    components.add(ToggleComponent.create("Enabled", state -> {
        settingsConfig.enabled(state);
        settingsConfig.saveConfig();
      },
      settingsConfig.enabled()));
  }
}
