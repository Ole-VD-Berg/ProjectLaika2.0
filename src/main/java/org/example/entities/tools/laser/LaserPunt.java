package org.example.entities.tools.laser;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;

public class LaserPunt extends DynamicCircleEntity implements Collider, UpdateExposer {
    private boolean laserSwitch;
    private GameScene gameScene;
    private Laser laser;
    private Coordinate2D mouseCoordinates;
    protected LaserPunt(Coordinate2D initialLocation, GameScene gameScene, Laser laser) {
        super(initialLocation);
        setRadius(20);
        setViewOrder(10);
        this.gameScene = gameScene;
        this.laser = laser;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long l) {
        this.laserSwitch = gameScene.getLaser();
        if (!laserSwitch) {
            setFill(Color.TRANSPARENT);
            setCursor(Cursor.DEFAULT);
        } else {
            setFill(Color.RED);
            setCursor(Cursor.NONE);
        }
        Coordinate2D mouseCoordinates = laser.getMouseCoordinates();

        if (mouseCoordinates != null) {
            double angle = angleTo(mouseCoordinates);
            double speed = distanceTo(mouseCoordinates);
            setMotion(speed, angle);
        }
    }
}
