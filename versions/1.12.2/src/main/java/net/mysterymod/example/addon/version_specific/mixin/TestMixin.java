package net.mysterymod.example.addon.version_specific.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class TestMixin {

  @Inject(method = "init", at = @At(value = "HEAD"))
  public void startGame(final CallbackInfo ci) {
    System.out.println("Hello from 1.12.2");
  }
}
