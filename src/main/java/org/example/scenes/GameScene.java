package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.laser.Laser;
import org.example.entities.overlays.OverlaySprite;
import org.example.entities.overlays.ScoreText;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondePlaneet;
import com.github.hanyaeger.api.Size;


public class GameScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer {
    private ProjectLaika game;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    public GameScene(ProjectLaika game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        ScoreText scoreText = new ScoreText(new Coordinate2D(200, 200));

        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlayNormal.png", new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
        addEntity(overlaySprite);
        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
        addEntity(laser);
        OnbewoondePlaneet O1 = new OnbewoondePlaneet(new Coordinate2D(100,100) ,200, game, this);
        addEntity(O1);
        addEntity(scoreText);

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
        //addEntitySpawner(new ObjectenSpawner(getWidth(), getHeight(), game, this));
    }
}
