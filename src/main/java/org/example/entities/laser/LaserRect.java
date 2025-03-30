package org.example.entities.laser;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import javafx.scene.input.MouseButton;

import static com.github.hanyaeger.api.entities.Direction.UP;
import static javafx.scene.paint.Color.color;

public class LaserRect extends DynamicRectangleEntity implements UpdateExposer, MouseMovedListener {
    Coordinate2D mouseCoordinates;
    double angle = 0;
    protected LaserRect(Coordinate2D initialLocation, Size size, Coordinate2D mouseCoordinates) {
        super(initialLocation);
        setMotion(0.1, UP);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.mouseCoordinates = mouseCoordinates;
        setFill(color(1, 0, 0));
        setWidth(15);
        setHeight(100);

    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {

        //mouseCoordinates = coordinate2D;
    }

    @Override
    public void explicitUpdate(long l) {
//System.out.println("Mouse coordinates heere: " + mouseCoordinates);
        angle = angleTo(mouseCoordinates);
        setRotate(angle);
        setMotion(0.5, angle);

    }


}
