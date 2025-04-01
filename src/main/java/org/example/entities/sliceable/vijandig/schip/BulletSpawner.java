package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
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

    private final double sceneWidth;
    private final double sceneHeight;
    private int direction;
    int speed = 10;

    Planeet planeet;
    public BulletSpawner(double sceneWidth, double sceneHeight) {
        super(300);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.direction = direction;

    }

    @Override
    protected void spawnEntities() {
            Bullet bullet = new Bullet("sprites/vijandig/bullet.png", new Coordinate2D(0, 0), direction, speed);
            spawn(bullet);

    }
    public void setDirection(int direction) {
        this.direction = direction;
    }


}

