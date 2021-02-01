package edbir.ponggame.game.objects;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import edbir.ponggame.game.Application;
import edbir.ponggame.game.GameScreen;

import edbir.ponggame.game.helper.BodyHelper;
import edbir.ponggame.game.helper.Const;
import edbir.ponggame.game.helper.ContactType;

public class Ball {

    private Body body;
    float x, y, speed, velX, velY;
    private int width, height;
    private GameScreen gameScreen;
    private Texture texture;

    public Ball(GameScreen gameScreen){
        this.x = Application.INSTANCE.getScreenWidth()/2;
        this.y = Application.INSTANCE.getScreenHeight()/2;
        this.speed = 5;

        this.texture = new Texture("white.png");

        this.velX = getRandomDirection();
        this.velY = getRandomDirection();

        this.width = 32;
        this.height = 32;

        this.body = BodyHelper.createBody(x, y, width, height, false, 0, gameScreen.getWorld(), ContactType.BALL);

    }

    private float getRandomDirection(){
        return (Math.random()< 0.5 )? 1: -1;
    }

    public void update(){
        x = body.getPosition().x * Const.PPM - (width/ 2);
        y = body.getPosition().y * Const.PPM - (width/ 2);

        this.body.setLinearVelocity(velX * speed ,velY * speed);

        //score
    }

    public void reset() {
        this.velX = getRandomDirection();
        this.velY = getRandomDirection();
        this.speed = 5;
        this.body.setTransform(Application.INSTANCE.getScreenWidth() / 2 / Const.PPM, Application.INSTANCE.getScreenHeight() / 2 / Const.PPM, 0);
    }
    public void render(SpriteBatch batch){
        batch.draw(texture, x, y, width, height);

    }
}
