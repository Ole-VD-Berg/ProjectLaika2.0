package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.SpaceShip.DamageHitbox;
import org.example.entities.text.ScoreText;
import org.example.entities.overlays.*;
import org.example.entities.sliceable.vijandig.schip.Schip;
import org.example.entities.timer.TimerText2;
import org.example.entities.tools.laser.Laser;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer {
    public ScoreText scoreText;
    private ProjectLaika game;
    private int score;
    private boolean laser = false;
    private boolean zaklamp = false;
    ObjectenSpawner objectenSpawner;
    int direction = 0;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    Schip schip;
    public GameScene(ProjectLaika game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");

    }


    @Override
    public void setupEntities() {

        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), this);
        addEntity(laser);
        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlaySpritesheet.png", new Coordinate2D(getWidth() /2, getHeight() / 2), new Size(getWidth(), getHeight()), 3,1);
        addEntity(overlaySprite);
//        PlanetenText planetenText = new PlanetenText(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 20), this, objectenSpawner);
//        addEntity(planetenText);
        scoreText = new ScoreText(new Coordinate2D(getWidth() * 0.61, getHeight() * 0.92), this);
        addEntity(scoreText);
        TimerText2 timerText2 = new TimerText2(new Coordinate2D(getWidth() / 2, getHeight() * 0.92), game, objectenSpawner);
        addEntity(timerText2);

        System.out.println(getWidth());
        schip = new Schip(new Coordinate2D(getWidth() / 2, getHeight() / 2), 100, game, this, 270);
        addEntity(schip);
        DamageHitbox damageHitbox = new DamageHitbox(new Coordinate2D(0, getHeight() - 10), new Size(getWidth(), 10), overlaySprite);
        addEntity(damageHitbox);

    }
    @Override
    public void setupEntitySpawners() {
        objectenSpawner = new ObjectenSpawner(getWidth(), getHeight(), game, this);
        addEntitySpawner(objectenSpawner);
//        BulletSpawner bulletSpawner = new BulletSpawner(getWidth(), getHeight(), this, schip);
//        addEntitySpawner(bulletSpawner);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        System.out.println(mouseButton);
        mouseCoordinates = coordinate2D;
        if (mouseButton == MouseButton.PRIMARY) {
            zaklamp = false;
            laser = !laser;

        }
        else if (mouseButton == MouseButton.SECONDARY) {
            laser = false;
            zaklamp = !zaklamp;

        }

    }
    public Coordinate2D getMouseCoordinates() {
        return mouseCoordinates;
    }


    public void doeScoreErbij(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public boolean getLaser() {
        return laser;
    }

    public void setLaser(boolean laser) {
        this.laser = laser;
    }

//    public int getDirection(){
//        return Schip.getDirection();
//    }

}
