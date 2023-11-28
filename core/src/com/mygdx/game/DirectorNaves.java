package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class DirectorNaves {
	public void buildNavebasica(NaveBuilder builder) {
		builder.xPos(Gdx.graphics.getWidth()/2-50);
		builder.yPos(30);
		builder.Sprite(new Texture(Gdx.files.internal("MainShip3.png")));
		builder.SoundHerido(Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")));
		builder.SoundBala(Gdx.audio.newSound(Gdx.files.internal("pop-sound.mp3")));
		builder.TextureBala(new Texture(Gdx.files.internal("Rocket2.png")));
	}
	
	public void buildNave4way(NaveBuilder builder) {
		builder.xPos(Gdx.graphics.getWidth()/2-50);
		builder.yPos(30);
		builder.Sprite(new Texture(Gdx.files.internal("MainEasyShip.png")));
		builder.SoundHerido(Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")));
		builder.SoundBala(Gdx.audio.newSound(Gdx.files.internal("pop-sound.mp3")));
		builder.TextureBala(new Texture(Gdx.files.internal("Rocket2.png")));
	}
}
