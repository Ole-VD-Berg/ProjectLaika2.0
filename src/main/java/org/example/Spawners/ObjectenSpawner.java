package org.example.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.entities.sliceable.planeten.bewoondePlaneet.BewoondePlaneet;
import org.example.entities.sliceable.planeten.onbekendePlaneet.OnbekendePlaneet;
import org.example.entities.sliceable.planeten.onbewoondPlaneet.OnbewoondePlaneet;
import org.example.entities.sliceable.vijandig.astroide.Astroide;
import org.example.entities.sliceable.vijandig.zwartgat.Zwartgat;
import org.example.scenes.GameScene;

import java.util.Random;



public class ObjectenSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private GameScene gameScene;
    private ProjectLaika game;
    private int direction = 1;
    private final int DOWN = 0;
    private final int AFWIJKING = 10;
    private final int RIGHT = 90;
    private final int UP = 180;
    private final int LEFT = 270;
    Planeet planeet;
    public ObjectenSpawner(double sceneWidth, double sceneHeight, ProjectLaika game, GameScene gameScene) {
        super(300);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.game = game;
        this.gameScene = gameScene;
    }

    @Override
    protected void spawnEntities() {
    int randomNummer = new Random().nextInt(12);
        if (randomNummer < 6) {
            OnbewoondePlaneet onbewoondePlaneet = new OnbewoondePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction));
            spawn(onbewoondePlaneet);
           // planeet = onbewoondePlaneet;

        } else if(randomNummer < 8){
            BewoondePlaneet bewoondePlaneet = new BewoondePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction));
            spawn(bewoondePlaneet);
           // planeet = bewoondePlaneet;
        }
        else if(randomNummer < 10){
            OnbekendePlaneet onbekendePlaneet = new OnbekendePlaneet(randomLocation(direction), 150, game, gameScene, angleConverter(direction));
            spawn(onbekendePlaneet);
          //  planeet = onbekendePlaneet;
        }
        else {
            int randomAstroide = new Random().nextInt(10);
            if (randomAstroide == 1) {
                Astroide astroide = new Astroide(new Coordinate2D(0,0), 100, game, gameScene, 45, 1);
                spawn(astroide);
            } else if (randomAstroide == 2) {
                Astroide astroide = new Astroide(new Coordinate2D(gameScene.getWidth() / 2, 50), 100, game, gameScene, 315, 0);
                spawn(astroide);
            } else if (randomAstroide == 3) {
                Zwartgat zwartgat = new Zwartgat(new Coordinate2D(new Random().nextDouble(gameScene.getWidth() / 2), new Random().nextDouble(gameScene.getHeight() /2)), 90, game, gameScene, 0, 0);
                spawn(zwartgat);
            }

        }

    }
//    public Planeet getPlaneet() {
//        return planeet;
//    }

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

                return new Random().nextInt(DOWN - AFWIJKING,DOWN + AFWIJKING);
            case 1:
                return new Random().nextInt(RIGHT - AFWIJKING,RIGHT + AFWIJKING);
            case 2:
                return new Random().nextInt(UP - AFWIJKING,UP + AFWIJKING);
            case 3:
                return new Random().nextInt(LEFT - AFWIJKING,LEFT + AFWIJKING);
            default:
                return 0;
        }
    }
}

