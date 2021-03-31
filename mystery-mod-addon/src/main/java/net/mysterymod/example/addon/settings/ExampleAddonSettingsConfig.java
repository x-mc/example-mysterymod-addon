package net.mysterymod.example.addon.settings;

import com.google.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.mysterymod.mod.config.GsonConfig;

import java.io.File;

@Getter
@Setter
@Singleton
@Accessors(fluent = true)
public class ExampleAddonSettingsConfig extends GsonConfig {
  private boolean enabled;

  private static final File SETTINGS_FILE = new File("MysteryMod/example_config.json");

  public ExampleAddonSettingsConfig() {
    super(SETTINGS_FILE);

    this.initialize();
  }
}
