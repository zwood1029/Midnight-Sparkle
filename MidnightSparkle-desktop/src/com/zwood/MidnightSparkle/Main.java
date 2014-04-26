package com.zwood.MidnightSparkle;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "MidnightSparkle";
		cfg.width = 500;
		cfg.height = 580;
		
		LwjglApplication my_application = new LwjglApplication(new MyGdxGame(), cfg);
		
		
	}
}
