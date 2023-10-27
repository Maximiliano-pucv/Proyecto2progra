package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class NaveBasica extends Nave {
	public NaveBasica(int x, int y, Texture tx, Sound soundChoque, Texture txBala, Sound soundBala){
		super(x, y, tx, soundChoque, txBala, soundBala);
		
	}
	

	@Override
	public void disparar(PantallaJuego juego) {
		// TODO Auto-generated method stub
		Sprite spr = getSprite();
		Texture txBala = getbulletexture();
		Sound soundBala = getSbala();
		Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,0,3,txBala);
	    juego.agregarBala(bala);
	    soundBala.play();
		
	}
	
	
}
