package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.*;

public class JefeF2 implements PerfilJefe  {
	private int x;
	private int y;
	private Sprite sprC;
	private Sprite sprO;
	private int vida;
	private ArrayList<MiniOjo> ojos = new ArrayList<>();
	
	public JefeF2(int x, int y, Texture tx,int vida) {
		sprC = new Sprite(tx);
		sprC.setPosition(x,y);
		sprC.setBounds(x, y, 1200, 200);
		this.vida = vida;
	}
	
	public void setVida(int V) {
		vida = V;
		
	}
	
	public int getVida() {
		return vida;
	}
	public Rectangle getAreaC() {
		return sprC.getBoundingRectangle();
	}
	public Rectangle getAreaO() {
		return sprO.getBoundingRectangle();
	}
	
    public void draw(SpriteBatch batch) {
    	sprC.draw(batch);
    	sprO.draw(batch);
    	for(int i = 0; i< ojos.size(); i++) {
    		MiniOjo aux = ojos.get(i);
    		aux.draw(batch);
    	}
    }
	public void atacar(PantallaJuego juego) {
		
	}
}
