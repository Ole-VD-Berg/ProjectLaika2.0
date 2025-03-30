package org.example.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.ProjectLaika;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondePlaneet;
import org.example.scenes.GameScene;

import java.util.Random;

public class ObjectenSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    GameScene gameScene;
    ProjectLaika game;
    public ObjectenSpawner(double sceneWidth, double sceneHeight, ProjectLaika game, GameScene gameScene) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.game = game;
        gameScene = gameScene;
    }

    @Override
    protected void spawnEntities() {
        if(new Random().nextInt(10) < 4){
            spawn(new OnbewoondePlaneet(randomLocation(), 200, game, gameScene));
        } else {

        }

    }

    private Coordinate2D randomLocation() {
        double x = new Random().nextInt((int) sceneWidth);
        return new Coordinate2D(x, sceneHeight / 2);
    }
}
