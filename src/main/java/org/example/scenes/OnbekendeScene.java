package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.onbekend.PlaneetHitbox;
import org.example.entities.onbekend.PlaneetSprite;
import org.example.entities.onbekend.maan.Maan;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.random;

public class OnbekendeScene extends DynamicScene implements UpdateExposer, MouseButtonPressedListener {
    ProjectLaika game;
    GameScene gameScene;
    private PlaneetSprite planeetSprite;
    private PlaneetHitbox planeetHitbox;
    private String planeet;
    private Random random = new Random();
    private int[] maanVolg = new int[] {1,2,3,4};
    private int maanKlick = 0;
    private int goed = 0;
    private boolean faal = false;
    private Maan maan1, maan2, maan3, maan4;
    private int bewoond = 0;
    private int gameCompleted = 0;

    public OnbekendeScene(ProjectLaika game, GameScene gameScene, int planeet) {
        this.game = game;
        this.gameScene = gameScene;
        this.planeet = "planeet" + planeet;
    }

    @Override
    public void setupScene( ) {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        planeetSprite = new PlaneetSprite("sprites/planeten/" + planeet + ".png", new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(500, 500));
        addEntity(planeetSprite);

        maakVolg(maanVolg);

        maan1 = new Maan(new Coordinate2D(getWidth() / 2.5, getHeight() / 2), this, maanVolg[0]);
        addEntity(maan1);

        maan2 = new Maan(new Coordinate2D(getWidth() / 1.66, getHeight() / 2), this, maanVolg[1]);
        addEntity(maan2);

        maan3 = new Maan(new Coordinate2D(getWidth() / 2, getHeight() / 3), this, maanVolg[2]);
        addEntity(maan3);

        maan4 = new Maan(new Coordinate2D(getWidth() / 2, getHeight() / 1.5), this, maanVolg[3]);
        addEntity(maan4);
    }

    private int getRandomNumber() {
        return random.nextInt(4);
    }

    @Override
    public void explicitUpdate(long l) {
        if(faal){
            gameScene.doeScoreErbij(-3);
            game.setActiveScene(1);
            setReset();
        }
        if (maan1.getBewoond() == 1 || maan2.getBewoond() == 1  || maan3.getBewoond() == 1  || maan4.getBewoond() == 1) {
            bewoond = 1;
            if(gameCompleted == 0) {
                setHitbox();
                gameCompleted++;
            }
        }
        if (maan1.getBewoond() == 2 || maan2.getBewoond() == 2  || maan3.getBewoond() == 2  || maan4.getBewoond() == 2) {
            bewoond = 2;
            if(gameCompleted == 0) {
                setHitbox();
                gameCompleted++;
            }
        }
        if(gameCompleted == 1){
            if(planeetHitbox.getPlaneetKlick()) {
             if (bewoond == 1) {
                 gameScene.doeScoreErbij(3);
             }
             if (bewoond == 2) {
                 gameScene.doeScoreErbij(-1);
             }
             System.out.println(planeetHitbox.getPlaneetKlick());
                setReset();
             game.setActiveScene(1);
             }
        }
    }

    public void setHitbox(){
        planeetHitbox = new PlaneetHitbox(new Coordinate2D(getWidth() / 2, getHeight() / 2), 500);
        addEntity(planeetHitbox);
    }

    public void setFaal(){
        faal = true;
    }

    public void setGoed(){
        goed++;
    }

    public void setMaanKlick(){
        maanKlick++;
    }

    public int getmaanKlick(){
        return maanKlick;
    }

    public void maakVolg(int[] array) {
        for (int r = 0; r < 20; r++) {
            for (int i = 0; i < array.length; i++) {
                int j = random.nextInt(i + 1);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(gameCompleted == 1) {
            if (bewoond == 1) {
                gameScene.doeScoreErbij(0);
            }
            if (bewoond == 2) {
                gameScene.doeScoreErbij(3);
            }
            setReset();
            game.setActiveScene(1);
        }
    }

    public void setReset(){
        maanKlick = 0;
        faal = false;
        goed = 0;
        bewoond = 0;
        maanVolg = new int[] {1,2,3,4};
        gameCompleted = 0;
        maan1.setRemover();
        maan2.setRemover();
        maan3.setRemover();
        maan4.setRemover();
        if(planeetHitbox != null) {
            planeetHitbox.remove();
        }
        planeetSprite.remove();
    }
}
