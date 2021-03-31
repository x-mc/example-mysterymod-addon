package net.mysterymod.example.addon.version_specific.ingame;

import net.minecraft.client.Minecraft;
import net.mysterymod.example.addon.ingame.IIngameTitle;

public final class IngameTitle implements IIngameTitle {
  private static final int FADE_IN_TIME = 10;
  private static final int FADE_OUT_TIME = 10;
  private static final int DISPLAY_TIME = 10;

  @Override
  public void display(String title) {
    Minecraft.getMinecraft().ingameGUI.displayTitle(title, "", FADE_IN_TIME, DISPLAY_TIME, FADE_OUT_TIME);
  }
}
