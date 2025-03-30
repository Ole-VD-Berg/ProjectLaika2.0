package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.laser.Laser;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondePlaneet;



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
        OnbewoondePlaneet O1 = new OnbewoondePlaneet(new Coordinate2D(100,100) ,200, game, this);
        addEntity(O1);
        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight() / 2), this);
        addEntity(laser);

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
}
