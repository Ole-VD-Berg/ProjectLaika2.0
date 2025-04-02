package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.onbekend.PlaneetSprite;
import org.example.entities.onbekend.maan.Maan;

import java.util.Collections;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.random;

public class OnbekendeScene extends DynamicScene implements UpdateExposer {
    ProjectLaika game;
    GameScene gameScene;
    private String planeet;
    private static Random random = new Random();
    private int[] maanVolg = new int[] {1,2,3,4};
    private int maanKlick = 0;
    private int goed = 0;
    private boolean faal = false;
    private Maan maan1, maan2, maan3, maan4;

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
        PlaneetSprite planeetSprite = new PlaneetSprite("sprites/planeten/" + planeet + ".png", new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(500, 500));
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
        System.out.println(goed + " " + faal + " " + maanKlick);
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
        for (int r = 0; r < 10; r++) {
            for (int i = 0; i < array.length; i++) {
                int j = random.nextInt(i + 1);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
    }
}
