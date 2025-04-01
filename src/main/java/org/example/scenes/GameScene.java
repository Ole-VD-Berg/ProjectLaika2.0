package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.overlays.SchermHitBox;
import org.example.entities.laser.Laser;
import org.example.entities.overlays.OverlaySprite;
import org.example.entities.overlays.ScoreText;
import org.example.entities.overlays.TestTimer;
import org.example.entities.overlays.TimerText;
import org.example.entities.planeten.Planeet;
import org.example.entities.planeten.bewoondePlaneet.BewoondePlaneet;
import org.example.entities.planeten.onbekendePlaneet.OnbekendePlaneet;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondePlaneet;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer, TimerContainer {
    public ScoreText scoreText;
    private ProjectLaika game;
    boolean isDragged = false;
    int direction = 0;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    public SchermHitBox schermHitBox;
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
        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlayCrack1.png", new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
        addEntity(overlaySprite);
        ScoreText scoreText = new ScoreText(new Coordinate2D(390, getHeight() - 32));
        addEntity(scoreText);
        TimerText timerText = new TimerText(new Coordinate2D(278, getHeight() - 32));
        addEntity(timerText);
        schermHitBox = new SchermHitBox(new Coordinate2D(0,0), game);
        addEntity(schermHitBox);
//        Planeet O1 = new OnbewoondePlaneet(new Coordinate2D(100,100) ,150, game, this, direction);
//        addEntity(O1);
//        Planeet O2 = new BewoondePlaneet(new Coordinate2D(300,100) ,150, game, this, direction);
//        addEntity(O2);
//        Planeet O3 = new OnbekendePlaneet(new Coordinate2D(200,100) ,150, game, this, direction);
//        addEntity(O3);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;


    }
    public Coordinate2D getMouseCoordinates() {
        return mouseCoordinates;
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new ObjectenSpawner(getWidth(), getHeight(), game, this));
    }

    @Override
    public void setupTimers() {
        TestTimer timer = new TestTimer(1000);
        addTimer(timer);
    }

}
