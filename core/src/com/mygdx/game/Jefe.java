package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Jefe implements PerfilJefe{
	private int x;
	private int y;
	//private int xSpeed;
	//private int ySpeed;
	private Sprite sprC;//sprite cuerpo
	private Sprite sprO;//sprite ojo
	private int vida;
	
	public Jefe(int x, int y, Texture tx,int vida) {
		sprC = new Sprite(tx);
		sprC.setPosition(x,y);
		sprC.setBounds(x, y, 1200, 200);
		this.vida = vida;
		
	}
	
	public void crearOjo(int x, int y, Texture tx) {
		sprO = new Sprite(tx);
		sprO.setPosition(x, y);
		sprO.setBounds(x, y, 233, 60);
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
    }
    
    
	public void setVida(int V) {
		vida = V;
	}

	public int getVida() {
		return vida;
	}
	
	public void atacar(PantallaJuego juego) {
		Bullet bala1 = new Bullet(600,544,0,-2,new Texture(Gdx.files.internal("Bala Jefe.png")));
		juego.agregarBalaj(bala1);
		Bullet bala2 = new Bullet(600,544,3,-2, new Texture(Gdx.files.internal("Bala Jefe.png")));
		juego.agregarBalaj(bala2);
		Bullet bala3 = new Bullet(600,544,-3,-2, new Texture(Gdx.files.internal("Bala Jefe.png")));
		juego.agregarBalaj(bala3);
	}
	
}
