package edbir.ponggame.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import edbir.ponggame.game.GameScreen;

public class Player1 extends PlayerPaddle {

    public Player1(float x, float y, GameScreen gameScreen){
        super(x,y,gameScreen);
    }

    public void update(){
        super.update();

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            velY = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            velY = -1;
        }

        body.setLinearVelocity(0, velY * speed);
    }
}
