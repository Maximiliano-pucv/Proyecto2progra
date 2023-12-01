package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EveryBalls {
	private  ArrayList<Ball2> balls1;
	private  ArrayList<Ball2> balls2;
	
	public EveryBalls () {
		balls1 = new ArrayList<>();
		balls2 = new ArrayList<>();
	}
	
	public void add(Ball2 bb) {
		balls1.add(bb);
		balls2.add(bb);
	}
	public void remove(int i) {
		balls1.remove(i);
		balls2.remove(i);
	}
	
	public Ball2 getB1(int i){
		return balls1.get(i);
	}
	
	public Ball2 getB2(int i){
		return balls2.get(i);
	}
	
	public int getsizeB1() {
		return balls1.size();
	}
	public int getsizeB2() {
		return balls1.size();
	}
	
	//actualizar movimiento de los asteroides
	public void actualizarMovimiento() {
		for (int i = 0; i < getsizeB1(); i++) {
	    	 Ball2 ball = getB1(i);
	    	 ball.update();
	    }
	}
	
	//colision entre asteroides 
	public void colisionAsteroides() {
		for (int i = 0; i < getsizeB1(); i++) {
	    	Ball2 ball1 =  getB1(i);    
	        for (int j = 0; j < getsizeB2(); j++) {
	        	Ball2 ball2 = getB2(j); 
	        	if (i < j) {
	        		ball1.checkCollision(ball2);
	     
	        	}
	        }
	    }
	}
	
	//se dibujan los asteroides y se maneja la colision de la nave
	public void colisionNave(Nave nave, SpriteBatch batch) {
		for (int i = 0; i < getsizeB1(); i++) {
			Ball2 b = getB1(i);
	    	b.draw(batch);
		    //pierde vida o game over
	        if (nave.checkCollision(b)) {
		       //asteroide se destruye con el choque             
	        	remove(i);
	        	i--;
            }   	  
	    }
	}
	
	//creacion de asteroides
	public void crearAsteroides(int ronda, int cantAsteroides) {
		Random r = new Random();
		Ball2Creator b = new Ball2Creator();
		for (int i = 0; i < cantAsteroides; i++) {
			
				/*Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           20+r.nextInt(10), velXAsteroides+r.nextInt(4), velYAsteroides+r.nextInt(4),3, 
			  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));*/
				
				/*System.out.println(abs(r.nextInt()%3));
				Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           1, 1, 1,3, 
			  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));*/
				//Ball2 bb = b.createBall(abs(r.nextInt()%3), r);
				Ball2 bb = b.createball2(abs(r.nextInt()%10), r);
				add(bb);	
				/*Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           20+r.nextInt(10), velXAsteroides+r.nextInt(4), velYAsteroides+r.nextInt(4),3, 
			  	           new Texture(Gdx.files.internal("aGreySmall.png")));*/
				//Ball2 bb = b.createBall(abs(r.nextInt()%3), r);
				//add(bb);
			//}
		}
		    
	}
	
	public int colisionBalaYAst(Bullet b, Sound ballhurt, Sound explosionSound, int score) {
		int puntaje = score;
		for (int h = 0; h < getsizeB1(); h++) {
			if (b.checkCollision(getB1(h))) {
				ballhurt.play();
				getB1(h).attacked();
				if(getB1(h).isdestroyed()) {
					explosionSound.play();
					remove(h);
					puntaje+=10;
					h--;
				}
            }   	  
	     }
		return puntaje;
	}

	private int  abs(int i) {
		if(i < 0) return i*-1;
		return i;
	}
	
	
}
