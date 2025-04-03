package org.example.entities.tools.zaklamp;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import org.example.entities.tools.laser.Laser;
import org.example.scenes.GameScene;

public class ZaklampPunt extends DynamicCircleEntity implements Collider, UpdateExposer {
    private boolean laserSwitch;
    private GameScene gameScene;
    private Zaklamp lamp;
    private Coordinate2D mouseCoordinates;
    protected ZaklampPunt(Coordinate2D initialLocation, GameScene gameScene, Zaklamp lamp) {
        super(initialLocation);
        setRadius(2);
        setViewOrder(10);
        this.gameScene = gameScene;
        this.lamp = lamp;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long l) {
        this.laserSwitch = gameScene.getLaser();
        if (!laserSwitch) {
            setFill(Color.TRANSPARENT);
            setCursor(Cursor.DEFAULT);
        } else {
            setFill(Color.YELLOW);
            setCursor(Cursor.NONE);
        }
        this.mouseCoordinates = lamp.getMouseCoordinates();

        if (mouseCoordinates != null) {
            double angle = angleTo(mouseCoordinates);
            double speed = distanceTo(mouseCoordinates);
            setMotion(speed, angle);
        }
    }
    public Coordinate2D getMouseCoordinates() {
        if (mouseCoordinates != null) {
            return mouseCoordinates;
        }
        return new Coordinate2D(0,0);
    }
}
