package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.SpaceShip.DamageHitbox;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.entities.sliceable.vijandig.astroide.Astroide;
import org.example.entities.text.PlanetenText;
import org.example.entities.text.ScoreText;
import org.example.entities.overlays.*;
import org.example.entities.sliceable.vijandig.schip.Schip;
import org.example.entities.timer.TimerText2;
import org.example.entities.tools.laser.Laser;
import org.example.entities.tools.zaklamp.Zaklamp;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer {
    public ScoreText scoreText;
    private ProjectLaika game;
    private Laser laser;
    private Zaklamp lamp;
    private int score;
    private boolean laserAan = false;
    private boolean zaklampAan = false;
    private ObjectenSpawner objectenSpawner;
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
    public void setupEntitySpawners() {
        objectenSpawner = new ObjectenSpawner(getWidth(), getHeight(), game, this);
        addEntitySpawner(objectenSpawner);
//        BulletSpawner bulletSpawner = new BulletSpawner(getWidth(), getHeight(), this, schip);
//        addEntitySpawner(bulletSpawner);
    }

    @Override
    public void setupEntities() {
        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlaySpritesheet.png", new Coordinate2D(getWidth() /2, getHeight() / 2), new Size(getWidth(), getHeight()), 3,1);
        addEntity(overlaySprite);
        PlanetenText planetenText = new PlanetenText(new Coordinate2D(getWidth() * 0.23, getHeight() * 0.92), this);
        addEntity(planetenText);
        scoreText = new ScoreText(new Coordinate2D(getWidth() * 0.65, getHeight() * 0.92), this);
        addEntity(scoreText);

        TimerText2 timerText2 = new TimerText2(new Coordinate2D(getWidth() / 2, getHeight() * 0.92), game, this, objectenSpawner);
        addEntity(timerText2);
        schip = new Schip(new Coordinate2D(getWidth() / 2, getHeight() / 2), 100, game, this, 270);
        addEntity(schip);
        DamageHitbox damageHitbox = new DamageHitbox(new Coordinate2D(0, getHeight() - 10), new Size(getWidth(), 10), overlaySprite);
        addEntity(damageHitbox);
        Astroide astroide = new Astroide(new Coordinate2D(getWidth() / 4, getHeight() / 4), 100, game, this, 45, 1);
        addEntity(astroide);

    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
        if (mouseButton == MouseButton.PRIMARY) {
            if(lamp != null) {
                lamp.setRemove();
            }
            zaklampAan = false;
            laserAan = !laserAan;
            setupLaser(laserAan);
        }
        else if (mouseButton == MouseButton.SECONDARY) {
            if(laser != null) {
                laser.setRemove();
            }
            laserAan = false;
            zaklampAan = !zaklampAan;
            setupZaklamp(zaklampAan);
        }

    }
    public Planeet getPlaneet(){
        return objectenSpawner.getPlaneet();

    }
    public ObjectenSpawner getObjectenSpawner(){
        return objectenSpawner;
    }
    public Coordinate2D getMouseCoordinates() {
        return mouseCoordinates;
    }

    public void setupLaser(boolean aan){
        if(aan){
            laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), this);
            addEntity(laser);
        }
        else{
            laser.setRemove();
        }
    }

    public void setupZaklamp(boolean aan){
        if(aan){
            lamp = new Zaklamp(new Coordinate2D(getWidth() / 2, getHeight()), this);
            addEntity(lamp);
        }
        else{
            lamp.setRemove();
        }
    }
    public void gefaalt(){
        game.setActiveScene(2);
        getPlaneet().resetGeslicedePlaneten();
    }
    public void doeScoreErbij(int score) {
        this.score += score;
        if(this.score < 0){
            this.score = 0;
        }
    }
    public int getScore() {
        return score;
    }

    public boolean getLaser() {
        return laserAan;
    }

    public void setLaser(boolean laser) {
        this.laserAan = laser;
    }
    public boolean getZaklamp() {
        return zaklampAan;
    }
    public void setZaklamp(boolean zaklamp) {
        this.zaklampAan = zaklamp;
    }
}
