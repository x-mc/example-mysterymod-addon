package net.mysterymod.example.addon.version_specific.ingame;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.mysterymod.example.addon.ingame.IIngameTitle;

public class IngameTitle implements IIngameTitle {
  private static final String EMPTY_STRING = "";
  private static final ITextComponent EMPTY_SUBTITLE_COMPONENT = ITextComponent.getTextComponentOrEmpty(EMPTY_STRING);

  private static final int FADE_IN_TIME = 10;
  private static final int FADE_OUT_TIME = 10;
  private static final int DISPLAY_TIME = 10;

  @Override
  public void display(String title) {
    StringTextComponent textComponent = createTextComponentFromTitle(title);
    Minecraft.getInstance().ingameGUI.func_238452_a_(textComponent, EMPTY_SUBTITLE_COMPONENT, FADE_IN_TIME, DISPLAY_TIME, FADE_OUT_TIME);
  }


  private StringTextComponent createTextComponentFromTitle(String title) {
    return new StringTextComponent(title);
  }
}
