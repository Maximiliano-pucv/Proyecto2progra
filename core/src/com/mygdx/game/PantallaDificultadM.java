package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class PantallaDificultadM implements Screen{
	private SpaceNavigation game;
	private OrthographicCamera camera;


	public PantallaDificultadM(SpaceNavigation game2) {
		// TODO Auto-generated constructor stub
		game = game2;
        
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1200, 800);
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();
		game.getFont().draw(game.getBatch(), "Dificultad media", 430, 500);
		game.getFont().draw(game.getBatch(), "Te mueves con WASD y disparas con las flechas", 230, 400);
		game.getFont().draw(game.getBatch(), "Presiona ESPACE para jugar", 230, 350);
		game.getBatch().end();

		/*if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			Screen ss = new PantallaJuego(game,1,3,0,1,1,10,1);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}*/
		
		if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			Screen ss = new PantallaJuego(game,1,3,0,1,1,10,2);
			ss.resize(1200, 800);
			game.setScreen(ss);
			dispose();
		}
	}
	
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		
	}

}
