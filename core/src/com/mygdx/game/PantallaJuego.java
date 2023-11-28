package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//test

public class PantallaJuego implements Screen {

	private SpaceNavigation game;
	private OrthographicCamera camera;	
	private SpriteBatch batch;
	private Sound explosionSound;
	private Music gameMusic;
	private int score;
	private int ronda;
	private int velXAsteroides; 
	private int velYAsteroides; 
	private int cantAsteroides;
	private int dificultad;
	//private Nave4 nave;
	
	private Nave nave;
	private  EveryBalls balls = new EveryBalls();
	private  ArrayList<Bullet> balas = new ArrayList<>();


	public PantallaJuego(SpaceNavigation game, int ronda, int vidas, int score,  
			int velXAsteroides, int velYAsteroides, int cantAsteroides, int dificultad) {
		this.dificultad = dificultad;
		this.game = game;
		this.ronda = ronda;
		this.score = score;
		this.velXAsteroides = velXAsteroides;
		this.velYAsteroides = velYAsteroides;
		this.cantAsteroides = cantAsteroides;
		
		batch = game.getBatch();
		camera = new OrthographicCamera();	
		camera.setToOrtho(false, 800, 640);
		//inicializar assets; musica de fondo y efectos de sonido
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosionXD.mp3"));
		explosionSound.setVolume(1,0.5f);
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("piano-loops.wav")); //
		
		gameMusic.setLooping(true);
		gameMusic.setVolume(0.5f);
		gameMusic.play();
		
	    // cargar imagen de la nave, 64x64
		if(dificultad == 1 ) {
			DirectorNaves Director = new DirectorNaves();
			NaveBuildercrear Builder = new NaveBuildercrear();
			Director.buildNavebasica(Builder);
			nave = Builder.Build(2);
			/*nave = new Nave4wayshoot(Gdx.graphics.getWidth()/2-50,30,new Texture(Gdx.files.internal("MainEasyShip.png")),
    				Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")), 
    				new Texture(Gdx.files.internal("Rocket2.png")), 
    				Gdx.audio.newSound(Gdx.files.internal("pop-sound.mp3"))); */
		}
		else {
			DirectorNaves Director = new DirectorNaves();
			NaveBuildercrear Builder = new NaveBuildercrear();
			Director.buildNave4way(Builder);
			nave = Builder.Build(1);
			/*nave = new NaveBasica(Gdx.graphics.getWidth()/2-50,30,new Texture(Gdx.files.internal("MainShip3.png")),
    				Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")), 
    				new Texture(Gdx.files.internal("Rocket2.png")), 
    				Gdx.audio.newSound(Gdx.files.internal("pop-sound.mp3"))); */
		}
	    
        nave.setVidas(vidas);
        crearAsteroides();
	}
	
	public void crearAsteroides() {
		Random r = new Random();
		for (int i = 0; i < cantAsteroides; i++) {
			if(ronda == 1) {
				Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           20+r.nextInt(10), velXAsteroides+r.nextInt(4), velYAsteroides+r.nextInt(4), 
			  	           new Texture(Gdx.files.internal("aGreyMedium4.png")));
				balls.add(bb);	
			}
			else {
				Ball2 bb = new Ball2(r.nextInt((int)Gdx.graphics.getWidth()),
						   50+r.nextInt((int)Gdx.graphics.getHeight()-50),
			  	           20+r.nextInt(10), velXAsteroides+r.nextInt(4), velYAsteroides+r.nextInt(4), 
			  	           new Texture(Gdx.files.internal("aGreySmall.png")));
				balls.add(bb);
			}
		}
		    
	}
    
	public void dibujaEncabezado() {
		CharSequence str = "Vidas: "+nave.getVidas()+" Ronda: "+ronda;
		game.getFont().getData().setScale(2f);		
		game.getFont().draw(batch, str, 10, 30);
		game.getFont().draw(batch, "Score:"+this.score, Gdx.graphics.getWidth()-150, 30);
		game.getFont().draw(batch, "HighScore:"+game.getHighScore(), Gdx.graphics.getWidth()/2-100, 30);
	}
	
	@Override
	public void render(float delta) {
		  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
          batch.begin();
		  dibujaEncabezado();
	      if (!nave.estaHerido()) {
		      // colisiones entre balas y asteroides y su destruccion
	    	  colisionUno();
	    	  
	    	  //actualizar movimiento de asteroides dentro del area
	    	  actualizarMov();
	    	  
	    	  //colisiones entre asteroides y sus rebotes  
	    	  colisionDos();
	    	  
	      }
	      //dibujar balas
	      for (Bullet b : balas) {       
	          b.draw(batch);
	      }
	      nave.draw(batch, this);
	      
	      //dibujar asteroides y manejar colision con nave
	      colisionNave();
	      
	      //Game Over
	      if (nave.estaDestruido()) {
	    	  if (score > game.getHighScore())
	  				game.setHighScore(score);
		    	Screen ss = new PantallaGameOver(game);
	  			ss.resize(1200, 800);
	  			game.setScreen(ss);
	  			dispose();
  		  }
	      batch.end();
	      
	      //nivel completado
	      if (balls.getsizeB1()==0) {
			Screen ss = new PantallaJuego(game,ronda+1, nave.getVidas(), score, 
					velXAsteroides+3, velYAsteroides+3, cantAsteroides+10,dificultad);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		  }	 
	}
    
	public void colisionUno() {
		for (int i = 0; i < balas.size(); i++) {
            Bullet b = balas.get(i);
            b.update();
            for (int j = 0; j < balls.getsizeB1(); j++) {    
              if (b.checkCollision(balls.getB1(j))) {          
            	 explosionSound.play();
            	 balls.remove(j);
            	 j--;
            	 score +=10;
              }   	  
  	        }
            if (b.isDestroyed()) {
                balas.remove(b);
                i--; //para no saltarse 1 tras eliminar del arraylist
            }
		}
		
	}
	
	public void actualizarMov() {
		for (int i =0; i<balls.getsizeB1();i++) {
	    	 Ball2 ball = balls.getB1(i);
	    	 ball.update();
	    }
	}
	
	public void colisionDos() {
		for (int i=0;i<balls.getsizeB1();i++) {
	    	Ball2 ball1 =  balls.getB1(i);    
	        for (int j=0;j<balls.getsizeB2();j++) {
	          Ball2 ball2 = balls.getB2(j); 
	          if (i<j) {
	        	  ball1.checkCollision(ball2);
	     
	          }
	        }
	    }
	}
	
	public void colisionNave() {
		for (int i = 0; i < balls.getsizeB1(); i++) {
			Ball2 b=balls.getB1(i);
	    	b.draw(batch);
		    //perdió vida o game over
	        if (nave.checkCollision(b)) {
		       //asteroide se destruye con el choque             
	        	balls.remove(i);
	        	i--;
            }   	  
	    }
	}
	
    public boolean agregarBala(Bullet bb) {
    	return balas.add(bb);
    }
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		gameMusic.play();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.explosionSound.dispose();
		this.gameMusic.dispose();
	}
   
}
