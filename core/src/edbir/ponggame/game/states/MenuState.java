package edbir.ponggame.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edbir.ponggame.game.Application;
import edbir.ponggame.game.GameScreen;

public class MenuState extends State{

    private Texture playBtn;

    public MenuState (GameStateManager gsm){
        super(gsm);
        playBtn = new Texture("playBtn.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            dispose();
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(playBtn, (Application.getInstance().getScreenWidth()/2 - (playBtn.getWidth()/2)),(Application.getInstance().getScreenHeight()/2 - (playBtn.getHeight()/2)));
        sb.end();
    }

    @Override
    public void dispose(){
        playBtn.dispose();
    }
}
