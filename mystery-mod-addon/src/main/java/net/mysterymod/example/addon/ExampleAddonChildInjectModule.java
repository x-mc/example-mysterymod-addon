package net.mysterymod.example.addon;

import com.google.inject.Binder;
import com.google.inject.Module;
import lombok.RequiredArgsConstructor;
import net.mysterymod.example.addon.ingame.IIngameTitle;

@RequiredArgsConstructor
public final class ExampleAddonChildInjectModule implements Module {
  @Override
  public void configure(Binder binder) {
    binder.bind(IIngameTitle.class).to(findVersionClass("ingame.IngameTitle"));
  }

  private <T> Class<? extends T> findVersionClass(String classPath) {
    try {
      Class<?> versionClass = Class.forName("net.mysterymod.example.addon.version_specific." + classPath);
      return (Class<? extends T>) versionClass;
    } catch (ClassNotFoundException classNotFoundFailure) {
      throw new RuntimeException(classNotFoundFailure);
    }
  }

  public static ExampleAddonChildInjectModule create() {
    return new ExampleAddonChildInjectModule();
  }
}
