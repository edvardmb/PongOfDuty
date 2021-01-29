package edbir.ponggame.game.helper;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BodyHelper {

    public static Body createBody(float x, float y, float width, float height, boolean isStatic, float density, World world, ContactType type){
        BodyDef bDef = new BodyDef();
        bDef.type = isStatic == false?BodyDef.BodyType.DynamicBody : BodyDef.BodyType.StaticBody;
        bDef.position.set(x/Const.PPM, y/Const.PPM);
        Body body = world.createBody(bDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / Const.PPM, height / 2 / Const.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        body.createFixture(fixtureDef).setUserData(type);

        shape.dispose();
        return body;
    }

}
