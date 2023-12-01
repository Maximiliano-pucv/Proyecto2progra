package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
		
	}
	
	public void draw(SpriteBatch batch) {
		ojo.draw(batch);
	}
	
	public void setVida(int v) {
		vida = v;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setD(boolean estado) {
		destruido = estado;
	}
	
	public boolean getEstado() {
		return destruido;
	}
	
	
}
