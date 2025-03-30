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
        spawn(new OnbewoondePlaneet(randomLocation(0), 200, game, gameScene));
//        if (new Random().nextInt(10) < 4) {
//
//        } else {
//
//        }

    }

    private Coordinate2D randomLocation(int direction) {
        switch (direction) {
            case 0:
                double x = new Random().nextInt((int) sceneWidth);
                return new Coordinate2D(x, 0);

            case 1:
                double y = new Random().nextInt((int) sceneHeight);
                return new Coordinate2D(0, y);

            case 2:
                double x2 = new Random().nextInt((int) sceneWidth);
                return new Coordinate2D(x2, sceneHeight);

            case 3:
                double y2 = new Random().nextInt((int) sceneHeight);
                return new Coordinate2D(sceneWidth, y2);


            default:
                return new Coordinate2D(0, 0);

        }
    }
}

