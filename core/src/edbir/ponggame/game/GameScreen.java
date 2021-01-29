package edbir.ponggame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import edbir.ponggame.game.objects.Player1;
import edbir.ponggame.game.objects.Player2;

public class GameScreen extends ScreenAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer b2dr;

    //Game objects
    private Player1 player1;
    private Player2 player2;


    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.camera.position.set(new Vector3(Application.INSTANCE.screenWidth / 2, Application.INSTANCE.screenHeight/2, 0));
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0,0), false);
        this.b2dr = new Box2DDebugRenderer();

        this.player1 = new Player1(16, Application.INSTANCE.getScreenHeight() / 2, this);
        this.player2 = new Player2(944, Application.INSTANCE.getScreenHeight() / 2, this);

    }

    public World getWorld() {
        return world;
    }

    public void update(){
        world.step(1/60f, 6, 2);
        batch.setProjectionMatrix(camera.combined);

        this.player1.update();
        this.player2.update();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }

    @Override
    public void render(float delta){
        update();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        this.player1.render(batch);
        this.player2.render(batch);
        batch.end();
    }
}