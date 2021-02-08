package edbir.ponggame.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

import edbir.ponggame.game.Application;
import edbir.ponggame.game.GameScreen;
import edbir.ponggame.game.helper.BodyHelper;
import edbir.ponggame.game.helper.ContactType;

public class Wall {

    private Body body;
    private float x, y;
    private int width, height;
    private Texture texture;

    public Wall(float y, GameScreen gameScreen){
        this. x = Application.getInstance().getScreenWidth()/2;
        this.y = y;
        this.width = Application.getInstance().getScreenWidth();
        this.height = 64;

        this.texture = new Texture("white.png");
        this.body = BodyHelper.createBody(x, y,width,height, true, 0, gameScreen.getWorld(), ContactType.WALL);
    }

    public void render(SpriteBatch batch){
        batch.draw(texture, x - (width/2), y-(height/2), width, height);
    }
}
