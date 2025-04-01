package org.example.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.ProjectLaika;
import org.example.entities.planeten.bewoondePlaneet.BewoondePlaneet;
import org.example.entities.planeten.onbekendePlaneet.OnbekendePlaneet;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondePlaneet;
import org.example.entities.vijandig.Astroide;
import org.example.scenes.GameScene;

import java.util.Random;

public class ObjectenSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    GameScene gameScene;
    ProjectLaika game;
    int direction = 2;
    public ObjectenSpawner(double sceneWidth, double sceneHeight, ProjectLaika game, GameScene gameScene) {
        super(300);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.game = game;
        this.gameScene = gameScene;
    }

    @Override
    protected void spawnEntities() {
    int randomNummer = new Random().nextInt(15);
        if (randomNummer < 6) {
            spawn(new OnbewoondePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction)));
        } else if(randomNummer < 8){
            spawn(new BewoondePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction)));
        }
        else if(randomNummer < 10){
            spawn(new OnbekendePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction)));
        }
        else {
            spawn(new Astroide(randomLocation(direction), 150, game, gameScene, angleConverter(direction)) {
                @Override
                protected void doSlicingActie() {

                }
            });
        }

    }

    private Coordinate2D randomLocation(int direction) {
        switch (direction) {
            case 0: //omlaag
                double x = new Random().nextInt((int) sceneWidth);
                return new Coordinate2D(x, 0);

            case 1: //rechts
                double y = new Random().nextInt((int) sceneHeight);
                return new Coordinate2D(0, y);

            case 2: //omhoog
                double x2 = new Random().nextInt((int) sceneWidth);
                System.out.println(sceneWidth);
                return new Coordinate2D(x2, sceneWidth * 0.35);



            case 3: //links
                double y2 = new Random().nextInt((int) sceneHeight);
                //System.out.println(sceneHeight);
                return new Coordinate2D(sceneHeight * 0.9, y2);



            default:
                return new Coordinate2D(0, 0);

        }
    }

    private int angleConverter(int direction) {
        switch (direction) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }
}

