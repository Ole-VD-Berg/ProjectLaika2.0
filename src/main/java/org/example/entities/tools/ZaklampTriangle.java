package org.example.entities.tools;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;


import static javafx.scene.paint.Color.color;

public class ZaklampTriangle extends DynamicSpriteEntity implements UpdateExposer {
    Coordinate2D mouseCoordinates;
    double angle = 0;
    GameScene gameScene;
    int height = 50;
    protected ZaklampTriangle(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
    }

    protected ZaklampTriangle(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
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
