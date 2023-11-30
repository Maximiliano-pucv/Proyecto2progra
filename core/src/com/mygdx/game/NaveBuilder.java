package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public interface NaveBuilder {
	public void xPos(int xPos);
	public void yPos(int yPos);
	public void Sprite(Texture tx);
	public void SoundHerido(Sound sonidoherido);
	public void SoundBala(Sound sonidobala);
	public void TextureBala(Texture txBala);
}
