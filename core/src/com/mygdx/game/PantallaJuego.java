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

public class PantallaJuego implements Screen, Dificultad {

	private SpaceNavigation game;
	private OrthographicCamera camera;	
	private SpriteBatch batch;
	private Sound explosionSound;
	private Sound ballhurt;
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
		ballhurt = Gdx.audio.newSound(Gdx.files.internal("ChargerBulletHit_ArmorThrough.wav"));
		explosionSound.setVolume(1,0.5f);
		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("Musica de fondo nivel normal.mp3")); //
		
		gameMusic.setLooping(true);
		gameMusic.setVolume(0.5f);
		gameMusic.play();
		
	    // cargar imagen de la nave, 64x64
		dificultadJuego();
        nave.setVidas(vidas);
        balls.crearAsteroides(ronda, cantAsteroides);
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
	    	  colisionBYA();
	    	  
	    	  //actualizar movimiento de asteroides dentro del area
	    	  balls.actualizarMovimiento();
	    	  
	    	  //colisiones entre asteroides y sus rebotes  
	    	  balls.colisionAsteroides();
	    	  
	      }
	      //dibujar balas
	      for (Bullet b : balas) {       
	          b.draw(batch);
	      }
	      nave.draw(batch, this);
	      
	      //dibujar asteroides y manejar colision con nave
	      balls.colisionNave(nave, batch);
	      
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
					velXAsteroides+3, velYAsteroides+3, cantAsteroides+3,dificultad);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		  }	 
	}
    
	public void colisionBYA() {
		for (int i = 0; i < balas.size(); i++) {
            Bullet b = balas.get(i);
            b.update();
            score = balls.colisionBalaYAst(b, ballhurt, explosionSound, score);
            /*for (int j = 0; j < balls.getsizeB1(); j++) {    
              if (b.checkCollision(balls.getB1(j))) {          
            	 ballhurt.play();
            	 balls.getB1(j).attacked();
            	 if(balls.getB1(j).isdestroyed()) {
            		 explosionSound.play();
            		 balls.remove(j);
            		 score +=10;
            		 j--;
            	 }
              }   	  
  	        }*/
            if (b.isDestroyed()) {
                balas.remove(b);
                i--; //para no saltarse 1 tras eliminar del arraylist
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


	@Override
	public void dificultadJuego() {
		// TODO Auto-generated method stub
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
	}
   
}
