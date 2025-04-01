package org.example.entities.tools;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;

import static javafx.scene.paint.Color.color;

public class LaserRect extends DynamicRectangleEntity implements UpdateExposer {
    Coordinate2D mouseCoordinates;
    double angle = 0;
    GameScene gameScene;
    int height = 50;
    protected LaserRect(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
        setFill(Color.RED);
        setWidth(15);
        setHeight(1050);
    }



    @Override
    public void explicitUpdate(long l) {
        mouseCoordinates = gameScene.getMouseCoordinates();
        angle = angleTo(mouseCoordinates);
        var distance = distanceTo(mouseCoordinates);
        setRotate(angle);
        setHeight(distance * 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
