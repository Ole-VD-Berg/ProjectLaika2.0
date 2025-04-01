package org.example.entities.tools;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;

import static javafx.scene.paint.Color.color;

public class LaserRect extends DynamicRectangleEntity implements UpdateExposer {
    private Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    double angle = 0;
    GameScene gameScene;
    boolean laserSwitch;
    private Laser laser;
    int height = 50;
    protected LaserRect(Coordinate2D initialLocation, GameScene gameScene, Laser laser) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
        setFill(Color.RED);
        setWidth(5);
        setHeight(1050);
        this.laser = laser;
        this.mouseCoordinates = laser.getMouseCoordinates();
    }



    @Override
    public void explicitUpdate(long l) {
        this.laserSwitch = gameScene.getLaser();
        if(!laserSwitch) {
            setFill(Color.TRANSPARENT);
        }
        else {setFill(Color.RED);}
            mouseCoordinates = laser.getMouseCoordinates();
        if (mouseCoordinates != null) {
            angle = angleTo(mouseCoordinates);
            var distance = distanceTo(mouseCoordinates);
            setRotate(angle);
            setHeight(distance * 2);
            setAnchorPoint(AnchorPoint.CENTER_CENTER);
        }
    }
}
