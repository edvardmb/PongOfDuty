package edbir.ponggame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Menu;

import edbir.ponggame.game.Application;

public class GameOver extends State {

    BitmapFont font;

    protected GameOver(GameStateManager gsm) {
        super(gsm);
        font = new BitmapFont();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            dispose();
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        font.draw(sb, "Game Over" , (Application.getInstance().getScreenWidth()/2)-50,Application.getInstance().getScreenHeight()/2 );
        font.draw(sb, "Click anywhere to play again", (Application.getInstance().getScreenWidth()/2)-100, (Application.getInstance().getScreenHeight()/2)-100);
        sb.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
