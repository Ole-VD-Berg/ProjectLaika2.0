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

    public Coordinate2D getMouseCoordinates() {
        if (mouseCoordinates != null) {
            return mouseCoordinates;
        }
        return new Coordinate2D(0,0);
    }

    @Override
    public void explicitUpdate(long l) {
        this.laserSwitch = gameScene.getLaser();
        this.mouseCoordinates = laser.getMouseCoordinates();
        if (mouseCoordinates != null) {
            double angle = angleTo(mouseCoordinates);
            double speed = distanceTo(mouseCoordinates);
            setMotion(speed, angle);
        }
        if (!laserSwitch) {
            setCursor(Cursor.DEFAULT);
            laser.setRemove();
        } else {
            setFill(Color.RED);
            setCursor(Cursor.NONE);
        }
    }
}
