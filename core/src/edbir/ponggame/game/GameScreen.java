package edbir.ponggame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import edbir.ponggame.game.objects.Ball;
import edbir.ponggame.game.objects.Player1;
import edbir.ponggame.game.objects.Player2;
import edbir.ponggame.game.objects.Wall;

public class GameScreen extends ScreenAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer b2dr;

    //Game objects
    private Player1 player1;
    private Player2 player2;
    private Ball ball;
    private Wall wallTop, wallBottom;

    BitmapFont font, font2, font3;


    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.camera.position.set(new Vector3(Application.getInstance().screenWidth / 2, Application.getInstance().screenHeight/2, 0));
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0,0), false);
        this.b2dr = new Box2DDebugRenderer();

        this.player1 = new Player1(16, Application.getInstance().getScreenHeight() / 2, this);
        this.player2 = new Player2(944, Application.getInstance().getScreenHeight() / 2, this);
        this.ball = new Ball( this);
        this.wallTop = new Wall(32, this);
        this.wallBottom = new Wall(Application.getInstance().getScreenHeight()-32, this);

        font = new BitmapFont();
        font2 = new BitmapFont();
        font3 = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(2,2);
        font2.setColor(Color.BLACK);
        font3.setColor(Color.RED);
        font3.getData().setScale(5,5);


    }

    public World getWorld() {
        return world;
    }

    public Player1 getPlayer1() {
        return player1;
    }

    public Player2 getPlayer2() {
        return player2;
    }

    public Ball getBall() {
        return ball;
    }

    public void update(){
        world.step(1/60f, 6, 2);
        batch.setProjectionMatrix(camera.combined);

        this.player1.update();
        this.player2.update();
        this.ball.update();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.ball.reset();

        }

    }

    public boolean isGameOver(){
        if (player1.getScore() == 21 || player2.getScore() == 21){
            ball.setVelX(0);
            ball.setSpeed(0);
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta){
        update();

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        if(isGameOver()){
            font3.draw(batch, "Game Over" , Application.getInstance().getScreenHeight()/2,Application.getInstance().getScreenWidth()/2 );
        }
        this.player1.render(batch);
        this.player2.render(batch);
        this.ball.render(batch);
        this.wallTop.render(batch);
        this.wallBottom.render(batch);

        font.draw(batch, (int) player1.getScore() + " - " +  (int) player2.getScore() , Application.getInstance().getScreenWidth()/2 ,Application.getInstance().getScreenHeight() -20 );
        font2.draw(batch, "Control left side with W and S " , 20,40 );
        font2.draw(batch, "Control left side with up and down " , Application.getInstance().getScreenWidth()/2 + 240  ,40);

        batch.end();

    }


}
