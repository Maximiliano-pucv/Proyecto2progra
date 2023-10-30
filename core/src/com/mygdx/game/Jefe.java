package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Jefe implements PerfilEnemigo{
	private int x;
	private int y;
	//private int xSpeed;
	//private int ySpeed;
	private Sprite spr;
	private int vida;
	
	public Jefe(int x, int y,int size, Texture tx) {
		spr = new Sprite(tx);
		
		this.x = x;
    	if (x-size < 0) this.x = x+size;
    	if (x+size > Gdx.graphics.getWidth())this.x = x-size;
    	
		this.y = y;
    	if (y-size < 0) this.y = y+size;
    	if (y+size > Gdx.graphics.getHeight())this.y = y-size;
	}
	
	public void update() {
		
	}
	
	public Rectangle getArea() {
		return spr.getBoundingRectangle();
	}
	
    public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
    
    public void checkCollision(Object b2) {
    	Jefe aux = (Jefe) b2;
    }
    
	public void setVida(int V) {
		vida = V;
	}
}
