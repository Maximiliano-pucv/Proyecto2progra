package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public abstract class Nave {
	private boolean destruida;
    private int vidas;
    private float xVel;
    private float yVel;
    private Sprite spr;
    private Sound sonidoHerido;
    private Sound soundBala;
    private Texture txBala;
    private boolean herido;
    private int tiempoHeridoMax;
    private int tiempoHerido;
    
    public Nave(int x, int y, Texture tx, Sound soundChoque, Texture txBala, Sound soundBala, int vidas,
    		float xVel, float  yVel, boolean herido, boolean destruida, int tiempoheridoMax){
    	this.destruida = destruida;
    	this.vidas = vidas;
    	this.xVel = xVel;
    	this.yVel = yVel;
    	this.herido = herido;
    	this.tiempoHeridoMax = tiempoheridoMax;
    	sonidoHerido = soundChoque;
    	this.soundBala = soundBala;
    	this.txBala = txBala;
    	spr = new Sprite(tx);
    	spr.setPosition(x, y);
    	//spr.setOriginCenter();
    	spr.setBounds(x, y, 45, 45);

    }
	
	public boolean checkCollision(Ball2 b) {
        if(!herido && b.getArea().overlaps(spr.getBoundingRectangle())){
        	// rebote
            if (xVel ==0) xVel += b.getXSpeed()/2;
            if (b.getXSpeed() ==0) b.setXSpeed(b.getXSpeed() + (int)xVel/2);
            xVel = - xVel;
            b.setXSpeed(-b.getXSpeed());
            
            if (yVel ==0) yVel += b.getySpeed()/2;
            if (b.getySpeed() ==0) b.setySpeed(b.getySpeed() + (int)yVel/2);
            yVel = - yVel;
            b.setySpeed(- b.getySpeed());
            // despegar sprites
      /*      int cont = 0;
            while (b.getArea().overlaps(spr.getBoundingRectangle()) && cont<xVel) {
               spr.setX(spr.getX()+Math.signum(xVel));
            }   */
        	//actualizar vidas y herir
            vidas--;
            herido = true;
  		    tiempoHerido=tiempoHeridoMax;
  		    sonidoHerido.play();
            if (vidas<=0) 
          	    destruida = true; 
            return true;
        }
        return false;
    }
	
	public abstract void disparar(PantallaJuego juego);
	
	// aca va lo del movimiento 
	public void draw(SpriteBatch batch, PantallaJuego juego){
        float x =  spr.getX();
        float y =  spr.getY();
        if (!herido) {
	        // que se mueva con teclado WASD pero con las flechas disparas para las naves avanzadas
        	// Es como el issac :D
        	/*if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) xVel = -5;
	        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) xVel= +5;
        	if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) yVel= -5;    
	        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) yVel= +5;*/
	        
	        if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
	        	xVel = -5;
	        	yVel = 0;
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
	        	xVel = 5;
	        	yVel = 0;
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
	        	xVel = 0;
	        	yVel = -5;
	        }
	        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
	        	xVel = 0;
	        	yVel = 5;
	        }
	        
        	
	        
	        // que se mantenga dentro de los bordes de la ventana
	        if (x+xVel < 0 || x+xVel+spr.getWidth() > Gdx.graphics.getWidth())
	        	xVel*=-1;
	        if (y+yVel < 0 || y+yVel+spr.getHeight() > Gdx.graphics.getHeight())
	        	yVel*=-1;
	        
	        spr.setPosition(x+xVel, y+yVel);   
         
 		    spr.draw(batch);
        } else {
           spr.setX(spr.getX()+MathUtils.random(-2,2));
 		   spr.draw(batch); 
 		   spr.setX(x);
 		   tiempoHerido--;
 		   if (tiempoHerido<=0) herido = false;
 		 }
        // disparar (funcion abstracta que dependera de la nave :D
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)||Gdx.input.isKeyJustPressed(Input.Keys.LEFT)||
        		Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)||Gdx.input.isKeyJustPressed(Input.Keys.DOWN)||Gdx.input.isKeyJustPressed(Input.Keys.UP)) {         
          /*Bullet  bala = new Bullet(spr.getX()+spr.getWidth()/2-5,spr.getY()+ spr.getHeight()-5,0,3,txBala);
	      juego.agregarBala(bala);
	      soundBala.play();*/
        	disparar(juego);
        }
	}
	
	public Sound getSbala() {
		return soundBala;
	}
	
	public Texture getbulletexture() {
		return txBala;
	}
	
    public Sprite getSprite() {
    	return spr;
    }
	
    public boolean estaDestruido() {
       return !herido && destruida;
    }
    public boolean estaHerido() {
 	   return herido;
    }
    
    public int getVidas() {return vidas;}
    //public boolean isDestruida() {return destruida;}
    public int getX() {return (int) spr.getX();}
    public int getY() {return (int) spr.getY();}
	public void setVidas(int vidas2) {vidas = vidas2;}
}
