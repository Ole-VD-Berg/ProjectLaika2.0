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
import org.example.entities.sliceable.vijandig.schip.BulletSpawner;
import org.example.entities.text.PlanetenText;
import org.example.entities.text.ScoreText;
import org.example.entities.overlays.*;
import org.example.entities.sliceable.vijandig.schip.Schip;
import org.example.entities.timer.TimerText2;
import org.example.entities.tools.laser.Laser;
import org.example.entities.tools.zaklamp.Zaklamp;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer, UpdateExposer {
    public ScoreText scoreText;
    private ProjectLaika game;
    private Laser laser;
    private Zaklamp lamp;
    private OverlaySprite overlaySprite;
    private static int score;
    private static int seconden = 0;
    private static int minuten = 2;
    private static int damage;
    private boolean laserAan = false;
    private boolean zaklampAan = false;
    private ObjectenSpawner objectenSpawner;
    private TimerText2 timerText2;
    private Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    private BulletSpawner bulletSpawner;
    private DamageHitbox damageHitbox;
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
        bulletSpawner = new BulletSpawner(this);
        addEntitySpawner(bulletSpawner);
    }

    @Override
    public void setupEntities() {
        overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlaySpritesheet.png", new Coordinate2D(getWidth() /2, getHeight() / 2), new Size(getWidth(), getHeight()), 3,1);
        addEntity(overlaySprite);
        PlanetenText planetenText = new PlanetenText(new Coordinate2D(getWidth() * 0.23, getHeight() * 0.92), this);
        addEntity(planetenText);
        scoreText = new ScoreText(new Coordinate2D(getWidth() * 0.65, getHeight() * 0.92), this);
        addEntity(scoreText);
        timerText2 = new TimerText2(new Coordinate2D(getWidth() / 2, getHeight() * 0.92), game, this, objectenSpawner);
        addEntity(timerText2);
        damageHitbox = new DamageHitbox(new Coordinate2D(getWidth() / 2, getHeight() - 10), new Size(getWidth() / 5, 10), overlaySprite, this);
        addEntity(damageHitbox);
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
            laserAan = false;
            zaklampAan = !zaklampAan;
            setupZaklamp(zaklampAan);
        }

    }

    public Planeet getPlaneet(){
        return objectenSpawner.getPlaneet();
    }
    public DamageHitbox getDamageHitbox(){return damageHitbox;}
    public BulletSpawner getBulletSpawner(){return bulletSpawner;}
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
        System.out.print(this.score + " + " + score);
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
    public void setSeconden(int seconden) {
        this.seconden = seconden;
    }
    public int getSeconden() {
        return seconden;
    }
    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }
    public int getMinuten() {
        return minuten;
    }
    public int getDamage(){
            return damage;
    }
    public void setDamage(int damage){
        GameScene.damage = damage;
    }
    public void setDamageMet1(){
        damage ++;
    }
    public void setReset(){
        seconden = 0;
        minuten = 2;
        score = 0;
        overlaySprite.setSpriteFrame(0);
    }

    @Override
    public void explicitUpdate(long l) {
        if(overlaySprite != null) {
            overlaySprite.setSpriteFrame(damage);
        }
    }
}
