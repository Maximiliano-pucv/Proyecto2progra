package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Nave4wayshoot extends Nave{
	
	public Nave4wayshoot(int x, int y, Texture tx, Sound soundChoque, Texture txBala, Sound soundBala){
		super(x, y, tx, soundChoque, txBala, soundBala);
		
	}

	@Override
	public void disparar(PantallaJuego juego) {
		// TODO Auto-generated method stub
		Sprite spr = getSprite();
		Texture txBala = getbulletexture();
		Sound soundBala = getSbala();
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,-3,0,txBala);
    	    juego.agregarBala(bala);
    	    soundBala.play();
		}
			
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
        	Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,3,0,txBala);
    	    juego.agregarBala(bala);
    	    soundBala.play();
        }
        	
    	if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
    		Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,0,-3,txBala);
    	    juego.agregarBala(bala);
    	    soundBala.play();
    	}
    		
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
        	Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,0,3,txBala);
    	    juego.agregarBala(bala);
    	    soundBala.play();
        }
	}
	

}
