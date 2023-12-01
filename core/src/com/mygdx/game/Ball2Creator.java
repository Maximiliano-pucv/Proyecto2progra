package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Ball2Creator {
	//clase que se va a a encargar de crear los asteroides y sus variaciones
	/*
	 tipos de meteoritos:
	 1- tamaño grande y velocidad baja y 3 de vida
	 2- tamaño mediano y velocidad media y 2 de vida
	 3- tamaño chiquito y velocidad alta y 1 de vida
	 */
	
	/*
	 * posicion x e y, tamaño, velocidad en x e y, vida , textura
	 * Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           20+r.nextInt(10), velXAsteroides+r.nextInt(4), velYAsteroides+r.nextInt(4),3, 
			  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));
	 */
	public Ball2 createBall(int i, Random r) {
		switch (i) {
		case 0:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   100+r.nextInt((int)Gdx.graphics.getHeight()-100),
					   20+r.nextInt(10), 1, 1,3, 
		  	           new Texture(Gdx.files.internal("aGreyLarge.png")));
		case 1:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
					   20+r.nextInt(10), 5, 5,2, 
		  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));
		case 2:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
					   20+r.nextInt(10), 10, 10,1, 
		  	           new Texture(Gdx.files.internal("aGreySmall.png")));
		default:  
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
				   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
				   1, 100, 100,2, 
	  	           new Texture(Gdx.files.internal("aGreyLarge.png")));
		}
	}
	public Ball2 createball2(int i, Random r ) {
		switch(i) {
		case 0:
		case 1:
		case 2:
		case 3:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
					   20+r.nextInt(10), 5, 5,2, 
		  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));
		case 4:
		case 5:
		case 6:
		case 7:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
					   20+r.nextInt(10), 10, 10,1, 
		  	           new Texture(Gdx.files.internal("aGreySmall.png")));
		case 8:
		case 9:
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
					   100+r.nextInt((int)Gdx.graphics.getHeight()-100),
					   20+r.nextInt(10), 1, 1,3, 
		  	           new Texture(Gdx.files.internal("aGreyLarge.png")));
		default:  
			return new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
				   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
				   1, 100, 100,2, 
	  	           new Texture(Gdx.files.internal("aGreyLarge.png")));
		}
	}
}
