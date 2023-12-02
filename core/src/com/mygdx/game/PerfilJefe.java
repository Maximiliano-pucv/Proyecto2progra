package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface PerfilJefe {
	public void setVida(int V);
	public int getVida();
	public Rectangle getAreaC();
	public void crearOjo(int x, int y, Texture tx);
	public Rectangle getAreaO();
	public void draw(SpriteBatch batch);
	public void atacar(PantallaJuego juego);
	
}
