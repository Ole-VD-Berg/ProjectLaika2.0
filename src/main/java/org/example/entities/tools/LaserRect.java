package org.example.entities.tools;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import javafx.scene.paint.Color;
import org.example.entities.overlays.SchermHitbox;
import org.example.scenes.GameScene;

import static javafx.scene.paint.Color.color;

public class LaserRect extends DynamicRectangleEntity implements UpdateExposer, MouseMovedListener, MouseMovedWhileDraggingListener {
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    double angle = 0;
    GameScene gameScene;
    boolean laser;
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
        this.laser = gameScene.getLaser();
        if(!laser) {
            setFill(Color.TRANSPARENT);
        }
        else {setFill(Color.RED);}
            //mouseCoordinates = gameScene.getMouseCoordinates();
            angle = angleTo(mouseCoordinates);
            var distance = distanceTo(mouseCoordinates);
            setRotate(angle);
            setHeight(distance * 2);
            setAnchorPoint(AnchorPoint.CENTER_CENTER);
            System.out.println(laser);

    }


    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
            mouseCoordinates = coordinate2D;
    }

    @Override
    public void onMouseMovedWhileDragging(Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
    }
}
