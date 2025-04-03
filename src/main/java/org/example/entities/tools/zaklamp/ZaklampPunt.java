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
    private boolean zaklampSwitch;
    private GameScene gameScene;
    private Zaklamp zaklamp;
    private Coordinate2D mouseCoordinates;
    protected ZaklampPunt(Coordinate2D initialLocation, GameScene gameScene, Zaklamp zaklamp) {
        super(initialLocation);
        setRadius(20);
        setViewOrder(10);
        this.gameScene = gameScene;
        this.zaklamp = zaklamp;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void explicitUpdate(long l) {
        this.zaklampSwitch = gameScene.getZaklamp();
        if (!zaklampSwitch) {
            setFill(Color.TRANSPARENT);
            setCursor(Cursor.DEFAULT);
        } else {
            setFill(Color.WHITE);
            setCursor(Cursor.NONE);
        }
        this.mouseCoordinates = zaklamp.getMouseCoordinates();

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
