package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Bullet {

	private int xSpeed;
	private int ySpeed;
	private boolean destroyed = false;
	private Sprite spr;
	private boolean Used = false;
	    
	    public Bullet(float x, float y, int xSpeed, int ySpeed, Texture tx) {
	    	spr = new Sprite(tx);
	    	spr.setPosition(x, y);
	        this.xSpeed = xSpeed;
	        this.ySpeed = ySpeed;
	    }
	    public void update() {
	        spr.setPosition(spr.getX()+xSpeed, spr.getY()+ySpeed);
	        if (spr.getX() < 0 || spr.getX()+spr.getWidth() > Gdx.graphics.getWidth()) {
	            destroyed = true;
	        }
	        if (spr.getY() < 0 || spr.getY()+spr.getHeight() > Gdx.graphics.getHeight()) {
	        	destroyed = true;
	        }
	        
	    }
	    
	    public void draw(SpriteBatch batch) {
	    	spr.draw(batch);
	    }
	    
	    public boolean checkCollision(Ball2 b2) {
	        if(spr.getBoundingRectangle().overlaps(b2.getArea())&&Used==false){
	        	
	        	// Se destruyen ambos
	            this.destroyed = true;
	            this.Used = true;
	            return true;
	
	        }
	        return false;
	    }
	    
	    public boolean isDestroyed() {return destroyed;}
	    
	public boolean checkCollisionJ(PerfilJefe j) {
		if(spr.getBoundingRectangle().overlaps(j.getAreaC()) && Used == false) {
			this.destroyed= true;
			this.Used = true;
			return true;
		}
		else {
			if(spr.getBoundingRectangle().overlaps(j.getAreaO()) && Used == false) {
				this.destroyed = true;
				this.Used = true;
				j.setVida(j.getVida()-1);
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCollisonOjP(MiniOjo o) {
		if(spr.getBoundingRectangle().overlaps(o.getArea()) && Used == false) {
			this.destroyed = true;
			this.Used = true;
			o.setVida(o.getVida()-1);
			return true;
		}
		return false;
	}
	
	
	public Rectangle getArea() {
		return spr.getBoundingRectangle();
	}
	public boolean getUse() {
		return Used;
	}
	public void setUse(boolean Use) {
		Used = Use;
	}
	
	public void setDest(boolean dest) {
		destroyed = dest;
	}
}
