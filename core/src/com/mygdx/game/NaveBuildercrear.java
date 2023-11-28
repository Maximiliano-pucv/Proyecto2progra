package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class NaveBuildercrear implements NaveBuilder {

	 private int xPos = 0;
	    private int yPos = 0;
	    private Texture tx;
	    private Sound sonidoHerido;
	    private Sound soundBala;
	    private Texture txBala;
	    
		@Override
		public void xPos(int xPos) {
			// TODO Auto-generated method stub
			this.xPos = xPos;
		}

		@Override
		public void yPos(int yPos) {
			// TODO Auto-generated method stub
			this.yPos = yPos;
		}

		@Override
		public void Sprite(Texture tx) {
			// TODO Auto-generated method stub
			this.tx = tx;
		}
		@Override
		public void SoundHerido(Sound sonidoherido) {
			// TODO Auto-generated method stub
			this.sonidoHerido =sonidoherido;
		}

		@Override
		public void SoundBala(Sound sonidobala) {
			// TODO Auto-generated method stub
			this.soundBala = sonidobala;
		}

		@Override
		public void TextureBala(Texture txBala) {
			// TODO Auto-generated method stub
			this.txBala=txBala;
		}
		
		public Nave Build(int i) {
			if(i!=1) {
				return new NaveBasica(xPos, yPos, tx, sonidoHerido, txBala, soundBala);
			}
			else return new Nave4wayshoot(xPos, yPos, tx, sonidoHerido, txBala, soundBala);
		}

}
