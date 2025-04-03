package org.example.entities.tools.zaklamp;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;
import org.example.scenes.GameScene;

public class ZaklampRect extends DynamicRectangleEntity implements UpdateExposer {
    private Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    double angle = 0;
    GameScene gameScene;
    boolean zaklampSwitch;
    private Zaklamp zaklamp;
    int height = 50;
    protected ZaklampRect(Coordinate2D initialLocation, GameScene gameScene, Zaklamp zaklamp) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
        setFill(Color.RED);
        setWidth(5);
        setHeight(10);
        this.zaklamp = zaklamp;
        this.mouseCoordinates = zaklamp.getMouseCoordinates();
    }



    @Override
    public void explicitUpdate(long l) {
        this.zaklampSwitch = gameScene.getZaklamp();
        if(!zaklampSwitch) {
            this.remove();
        }
        else {setFill(Color.WHITE);}
            mouseCoordinates = zaklamp.getMouseCoordinates();
        if (mouseCoordinates != null) {
            angle = angleTo(mouseCoordinates);
            var distance = distanceTo(mouseCoordinates);
            setRotate(angle);
            setHeight(distance * 2);
            setAnchorPoint(AnchorPoint.CENTER_CENTER);
        }
    }
}
