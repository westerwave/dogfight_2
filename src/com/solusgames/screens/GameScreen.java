package com.solusgames.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.controls.Controls;
import com.solusgames.entities.planes.Plane;
import com.solusgames.entities.planes.Planetype;
import com.solusgames.render.Render;

public class GameScreen implements Screen {
    Controls c = new Controls();
    Render r = new Render();

    @Override
    public void dispose() {
	// TODO Auto-generated method stub

    }

    @Override
    public void hide() {
	// TODO Auto-generated method stub

    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub

    }

    public void update() {
	c.input();
	Global.player1.update2();

	if (Global.player1.getXpos() >= Global.dim_720.getWidth()
		|| Global.player1.getYpos() >= Global.dim_720.getHeight()
		|| Global.player1.getYpos() <= 0
		|| Global.player1.getXpos() <= 0) {
	    Global.player1.setXpos(100);
	    Global.player1.setYpos(100);
	}
    }

    @Override
    public void render(float delta) {
	// System.out.println(Gdx.graphics.getFramesPerSecond());
	update();

	r.render();

    }

    @Override
    public void resize(int width, int height) {
	// TODO Auto-generated method stub

    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub

    }

    @Override
    public void show() {
	Global.player1 = new Plane(100, 100, 0, new Planetype(100, 6, 1, 2,
		true, true, true, true, new Texture(
			Gdx.files.internal("assets/data/planes/plane1.png"))));

    }

}
