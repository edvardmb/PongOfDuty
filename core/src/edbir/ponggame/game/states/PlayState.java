package edbir.ponggame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edbir.ponggame.game.Application;
import edbir.ponggame.game.GameScreen;

public class PlayState extends State {
    GameScreen gameScreen;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        this.gameScreen = new GameScreen(orthographicCamera);
        orthographicCamera.setToOrtho(false, Application.getInstance().screenWidth, Application.getInstance().screenHeight);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        gameScreen.update();
        if(gameScreen.isGameOver()){
            dispose();
            gsm.set(new GameOver(gsm));
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(orthographicCamera.combined);
        gameScreen.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }
}
