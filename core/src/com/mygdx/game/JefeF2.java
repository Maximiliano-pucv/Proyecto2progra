package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.*;

public class JefeF2 implements PerfilJefe  {
	private int x;
	private int y;
	private Sprite sprC;//sprite cuerpo
	private Sprite sprO;//sprite ojo
	private int vida;
	private ArrayList<MiniOjo> ojos = new ArrayList<>();
	
	public JefeF2(int x, int y, Texture tx,int vida) {
		sprC = new Sprite(tx);
		sprC.setPosition(x,y);
		sprC.setBounds(x, y, 1200, 200);
		this.vida = vida;
		ojos.add(new MiniOjo(100,545,new Texture(Gdx.files.internal("ojoP.png")),10));
		ojos.add(new MiniOjo(999,545,new Texture(Gdx.files.internal("ojoP.png")),10));
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
	
	
	public void crearOjo(int x, int y, Texture tx) {
		sprO = new Sprite(tx);
		sprO.setPosition(x, y);
		sprO.setBounds(x, y, 233, 60);
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
		if(ojos.size() == 0) {
			Bullet bala1 = new Bullet(600,544,0,-2,new Texture(Gdx.files.internal("Bala Jefe.png")));
			juego.agregarBalaj(bala1);
			Bullet bala2 = new Bullet(600,544,3,-2, new Texture(Gdx.files.internal("Bala Jefe.png")));
			juego.agregarBalaj(bala2);
			Bullet bala3 = new Bullet(600,544,-3,-2, new Texture(Gdx.files.internal("Bala Jefe.png")));
			juego.agregarBalaj(bala3);
		}

		for (int i = 0; i<ojos.size();i++) {
			MiniOjo aux = ojos.get(i);
			aux.atacar(juego);
			
		}
	}
	
	//obtener cantidad de ojos
	public int getCantMo() {
		return ojos.size();
	}
	
	// obtiene objeto MiniOjo
	public MiniOjo getOjo(int i) {
		return ojos.get(i);
	}
	
	// revisar Vida de los mini ojos
	public void checkVida() {
		for(int i = 0; i< ojos.size();i++) {
			MiniOjo aux = ojos.get(i);
			if (aux.getVida() == 0) {
				ojos.remove(i);
			}
		}
	}
}
