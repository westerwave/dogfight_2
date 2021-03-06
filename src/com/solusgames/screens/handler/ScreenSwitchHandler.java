package com.solusgames.screens.handler;

import com.badlogic.gdx.Gdx;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.screens.Screen;
import com.solusgames.screens.ScreenManager;
import com.solusgames.screens.parts.Button.ButtonHandler;

public class ScreenSwitchHandler implements ButtonHandler {

    private Screen screen = null;
    private boolean changed = false;

    public ScreenSwitchHandler(Screen screen) {
	this.screen = screen;
    }

    @Override
    public void onClick() {
	if (!changed) {
	    /* easily implemented screen switching thanks to singleton pattern */
	    ScreenManager.getInstance().show(screen);
	    // remove if possible
	    if (screen == Screen.GAME) {
		Global.paused = false;
		Gdx.input.setInputProcessor(Global.control);
	    }
	    changed = true;
	}
    }

    @Override
    public void onRelease() {
	changed = false;
    }

}
