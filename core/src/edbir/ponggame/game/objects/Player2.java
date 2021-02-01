package edbir.ponggame.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import edbir.ponggame.game.GameScreen;

public class Player2 extends PlayerPaddle {

    public Player2(float x, float y, GameScreen gameScreen){
        super(x,y,gameScreen);
    }

    public void update(){
        super.update();

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            velY = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            velY = -1;
        }

        body.setLinearVelocity(0, velY * speed);
    }

    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float getScore(){
        return this.score;
    }
    public void resetScore(){
        this.score = 0;
    }
}
