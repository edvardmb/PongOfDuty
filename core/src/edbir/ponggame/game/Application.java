package edbir.ponggame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.xpath.internal.operations.Or;

import edbir.ponggame.game.states.GameStateManager;
import edbir.ponggame.game.states.MenuState;

public final class Application extends Game {

	private static final Application INSTANCE = new Application();


	public int screenWidth, screenHeight;

	private Application (){
	}

	public static Application getInstance(){
		return INSTANCE;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	private GameStateManager gsm;
	private SpriteBatch batch;

	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		this.screenWidth = Gdx.graphics.getWidth();
		this.screenHeight = Gdx.graphics.getHeight();
		gsm.push(new MenuState(gsm));

		//setScreen(new GameScreen(orthographicCamera));
	}

	public void render(){
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

}
