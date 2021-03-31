package net.mysterymod.example.addon.modules;

import net.mysterymod.api.module.category.ModuleCategory;
import net.mysterymod.api.module.text.SimpleKeyValueModule;
import net.mysterymod.mod.message.MessageRepository;

public class ExampleModule extends SimpleKeyValueModule {
  @Override
  public String getKey(MessageRepository messageRepository, boolean shownIngame) {
    return "Your-Key-Message";
  }

  @Override
  public String getValue(MessageRepository messageRepository, boolean shownIngame) {
    return "Your-Value-Message";
  }

  @Override
  public String getDisplayName(MessageRepository messageRepository) {
    return "Example";
  }

  @Override
  public ModuleCategory getCategory() {
    return ExampleAddonCategory.MODULE_CATEGORY;
  }
}
