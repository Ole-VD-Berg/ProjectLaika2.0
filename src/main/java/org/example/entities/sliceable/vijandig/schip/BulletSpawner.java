package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.entities.sliceable.planeten.bewoondePlaneet.BewoondePlaneet;
import org.example.entities.sliceable.planeten.onbekendePlaneet.OnbekendePlaneet;
import org.example.entities.sliceable.planeten.onbewoondPlaneet.OnbewoondePlaneet;
import org.example.scenes.GameScene;

import java.util.Optional;
import java.util.Random;


public class BulletSpawner extends EntitySpawner {
    private final GameScene gameScene;
    Schip schip;
    private int direction;
    int speed = 10;
    Coordinate2D coordinates = new Coordinate2D(0,0);
    public BulletSpawner(GameScene gameScene) {
        super(500);
        this.gameScene = gameScene;
    }


    @Override
    protected void spawnEntities() {
        if(gameScene.getObjectenSpawner().getSchip() != null) {
            System.out.println(gameScene.getObjectenSpawner().getSchip());
            Bullet bullet = new Bullet("sprites/vijandig/bullet.png", coordinates, direction, speed);
            spawn(bullet);
        }

    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    public void setCoordinates(Coordinate2D coordinaten){
        coordinates = coordinaten;
    }




}

