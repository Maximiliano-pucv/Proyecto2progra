package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Ball2 {
	//añadi comentarios
	private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private Sprite spr;
    private int vida;
    public Ball2(int x, int y, int size, int xSpeed, int ySpeed,int vida, Texture tx) {
    	spr = new Sprite(tx);
    	this.x = x; 
    	this.vida = vida;
        //validar que borde de esfera no quede fuera
    	if (x-size < 0) this.x = x+size;
    	if (x+size > Gdx.graphics.getWidth())this.x = x-size;
         
        this.y = y;
        //validar que borde de esfera no quede fuera
    	if (y-size < 0) this.y = y+size;
    	if (y+size > Gdx.graphics.getHeight())this.y = y-size;
    	
        spr.setPosition(x, y);
        this.setXSpeed(xSpeed);
        this.setySpeed(ySpeed);
    }
    public void update() {
        x += getXSpeed();
        y += getySpeed();

        if (x+getXSpeed() < 0 || x+getXSpeed()+spr.getWidth() > Gdx.graphics.getWidth())
        	setXSpeed(getXSpeed() * -1);
        if (y+getySpeed() < 0 || y+getySpeed()+spr.getHeight() > Gdx.graphics.getHeight())
        	setySpeed(getySpeed() * -1);
        spr.setPosition(x, y);
    }
    
    public Rectangle getArea() {
    	return spr.getBoundingRectangle();
    }
    public void draw(SpriteBatch batch) {
    	spr.draw(batch);
    }
    
    public void checkCollision(Object b2) {
    	Ball2 aux = (Ball2) b2;
        if(spr.getBoundingRectangle().overlaps(aux.spr.getBoundingRectangle())){
        	// rebote
            if (getXSpeed() ==0) setXSpeed(getXSpeed() + aux.getXSpeed()/2);
            if (aux.getXSpeed() ==0) aux.setXSpeed(aux.getXSpeed() + getXSpeed()/2);
        	setXSpeed(- getXSpeed());
        	aux.setXSpeed(-aux.getXSpeed());
            
            if (getySpeed() ==0) setySpeed(getySpeed() + aux.getySpeed()/2);
            if (aux.getySpeed() ==0) aux.setySpeed(aux.getySpeed() + getySpeed()/2);
            setySpeed(- getySpeed());
            aux.setySpeed(- aux.getySpeed()); 
        }
    }
    
    public void attacked() {
    	vida--;
    }
    
    public boolean isdestroyed() {
    	if(vida < 1) return true;
    	return false;
    }
    
	public int getXSpeed() {
		return xSpeed;
	}
	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public void setVida(int V) {
		vida = V;
	}
    public int getVida() {
    	return vida;
    }
}
