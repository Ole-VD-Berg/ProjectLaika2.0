package org.example.entities.laser;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;

import static com.github.hanyaeger.api.entities.Direction.UP;
import static javafx.scene.paint.Color.color;

public class LaserRect extends DynamicRectangleEntity implements UpdateExposer {
    Coordinate2D mouseCoordinates;
    double angle = 0;
    GameScene gameScene;
    int height = 50;
    protected LaserRect(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        //setMotion(0.1, UP);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
        setFill(Color.RED);
        setWidth(15);
        setRotate(180);
        //setHeight(50);


    }



    @Override
    public void explicitUpdate(long l) {
        mouseCoordinates = gameScene.getMouseCoordinates();
        angle = angleTo(mouseCoordinates);
        //height++;
        //setRotate(angle);
        //setMotion(0.5, angle);

        double invertedDistance = distanceTo(mouseCoordinates) * -1;
        setHeight(distanceTo(mouseCoordinates));
      //  System.out.println("x -1 " + distanceTo(mouseCoordinates) * -1 + ", zonder: " + distanceTo(mouseCoordinates));

    }
}
