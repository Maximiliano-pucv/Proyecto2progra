package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface PerfilEnemigo {
	public void update();
	public Rectangle getArea();
    public void draw(SpriteBatch batch);
	public void setVida(int V);
	public int getVida(int v);
	public void checkCollision(Object b2);
	public int getXSpeed();
	public void setXSpeed(int xSpeed);
	public int getySpeed();
	public void setySpeed(int ySpeed);
}
