package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MiniOjo {
	private int x;
	private int y;
	private Sprite ojo;
	private int vida;
	private boolean destruido = false;
	
	public MiniOjo(int x, int y, Texture tx,int v) {
		this.x = x;
		this.y = y;
		ojo = new Sprite(tx);
		ojo.setPosition(x, y);
		vida = v;
		ojo.setBounds(x, y, 100, 60);
	}
	
	public void draw(SpriteBatch batch) {
		ojo.draw(batch);
	}
	
	public void setVida(int v) {
		vida = v;
	}
	public Rectangle getArea() {
		return ojo.getBoundingRectangle();
	}
	
	public int getVida() {
		return vida;
	}
	
	public void atacar(PantallaJuego juego) {
		Bullet bala1 = new Bullet(x+50,564,0,-2,new Texture(Gdx.files.internal("Bala Jefe.png")));
		juego.agregarBalaj(bala1);
	}
	
}
