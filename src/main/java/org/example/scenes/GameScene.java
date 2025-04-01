package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.overlays.*;
import org.example.entities.timer.TimerText2;
import org.example.entities.tools.laser.Laser;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer {
    public ScoreText scoreText;
    private ProjectLaika game;
    private int score;
    private boolean laser = false;
    ObjectenSpawner objectenSpawner;
    int direction = 0;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    public SchermHitbox schermHitbox;
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
    }

    @Override
    public void setupEntities() {
        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), this);
        addEntity(laser);
        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlaySpritesheet.png", new Coordinate2D(0, 0), new Size(getWidth(), getHeight()), 3,1);
        addEntity(overlaySprite);
//        PlanetenText planetenText = new PlanetenText(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 20), this, objectenSpawner);
//        addEntity(planetenText);
        scoreText = new ScoreText(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
        addEntity(scoreText);
        TimerText2 timerText2 = new TimerText2(new Coordinate2D(getWidth() / 2, getHeight() / 2), game, objectenSpawner);
        addEntity(timerText2);
        schermHitbox = new SchermHitbox(new Coordinate2D(0,0), game);
        addEntity(schermHitbox);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
        laser = !laser;
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


}
