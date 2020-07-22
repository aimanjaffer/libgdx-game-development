package com.aiman.game.desktop;

import com.aiman.game.BasketBallGame;
import com.aiman.game.Drop;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Drop");
		config.setWindowedMode(800,400);
		new Lwjgl3Application(new Drop(), config);
	}
}
