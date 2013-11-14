package com.solusgames.entities.weapons;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.solusgames.Dogfight_2.Global;
import com.solusgames.entities.Entity;

public class Weapon extends Entity {

    private Weapontype type;
    private boolean alive;
    private float originX;
    private float originY;

    public Weapon(float x, float y, float angle, Texture texture,
	    Weapontype type, EntityType EType) {
	super(x, y, angle, 0, texture, EType);
	alive = true;
	this.type = type;
	originX = getSprite().getWidth() / 2;
	originY = getSprite().getHeight() / 2;

    }

    public void render(SpriteBatch batch) {
	batch.end();
	batch.begin();

	getSprite().setPosition(xpos, ypos);
	getSprite().setOrigin(originX, originY);
	getSprite().setRotation(angle);
	getSprite().draw(batch);

	batch.end();
	batch.begin();
    }

    public void update() {
	
	if (alive) {
	    checkCollision();
	    xpos += type.getMinSpeed() * Math.cos(Math.toRadians(angle));
	    ypos += type.getMinSpeed() * Math.sin(Math.toRadians(angle));
	} else {

	}
    }

    /**
     * Plays sound belonging to weapon type
     */
    public void playSound() {
	type.getSound().play(Global.sounds_volume);
    }

    public void checkCollision() {
	Vector2 minmin = new Vector2(getSprite().getVertices()[0], getSprite()
		.getVertices()[1]);
	Vector2 minmax = new Vector2(getSprite().getVertices()[5], getSprite()
		.getVertices()[6]);
	Vector2 maxmin = new Vector2(getSprite().getVertices()[15], getSprite()
		.getVertices()[16]);
	Vector2 maxmax = new Vector2(getSprite().getVertices()[10], getSprite()
		.getVertices()[11]);
	// map collision
	for (ArrayList<Vector2> r : Global.col_map) {
	    Array<Vector2> arr = Global.toArray(r);
	    if (Intersector.isPointInPolygon(arr, minmin)
		    || Intersector.isPointInPolygon(arr, minmax)
		    || Intersector.isPointInPolygon(arr, maxmin)
		    || Intersector.isPointInPolygon(arr, maxmax)) {
		setAlive(false);
	    }
	}
	// bounds collision
	if (getXpos() >= Global.map_rows * Global.map_tileWidth
		|| getYpos() >= Global.map_columns * Global.map_tileHeight
		|| getYpos() <= 0 || getXpos() <= 0) {
	    setAlive(false);
	}
	
	if (EType == EntityType.WEAPON_PLAYER1) {
	  
	    Array<Vector2> poly = Global.player2.returnSpriteCornerArray();
	    if (Intersector.isPointInPolygon(poly, minmin)
		    || Intersector.isPointInPolygon(poly, minmax)
		    || Intersector.isPointInPolygon(poly, maxmin)
		    || Intersector.isPointInPolygon(poly, maxmax)) {
		setAlive(false);
		Global.player2.addHitpoints(-type.getDamage());
	    }
	} else if (EType == EntityType.WEAPON_PLAYER2) {
	    Array<Vector2> poly = Global.player1.returnSpriteCornerArray();
	    if (Intersector.isPointInPolygon(poly, minmin)
		    || Intersector.isPointInPolygon(poly, minmax)
		    || Intersector.isPointInPolygon(poly, maxmin)
		    || Intersector.isPointInPolygon(poly, maxmax)) {
		setAlive(false);
		Global.player1.addHitpoints(-type.getDamage());
	    }
	}
    }

    /**
     * Dispose method
     */
    public void dispose() {
	super.dispose();
	getType().getTexture().dispose();
    }

    /**
     * @return the type
     */
    public Weapontype getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Weapontype type) {
	this.type = type;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
	return alive;
    }

    /**
     * @param alive
     *            the alive to set
     */
    public void setAlive(boolean alive) {
	this.alive = alive;
    }

}
