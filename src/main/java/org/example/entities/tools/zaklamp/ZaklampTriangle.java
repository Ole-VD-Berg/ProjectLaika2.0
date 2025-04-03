package org.example.entities.tools.zaklamp;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import javafx.scene.paint.Color;
import org.example.entities.tools.laser.Laser;
import org.example.scenes.GameScene;


import static javafx.scene.paint.Color.color;

public class ZaklampTriangle extends DynamicRectangleEntity implements UpdateExposer {
    private Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    double angle = 0;
    GameScene gameScene;
    boolean zaklampSwitch;
    private Zaklamp lamp;
    int height = 50;
    protected ZaklampTriangle(Coordinate2D initialLocation, GameScene gameScene, Zaklamp lamp) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.gameScene = gameScene;
        this.lamp = lamp;
        mouseCoordinates = lamp.getMouseCoordinates();
        setFill(Color.TRANSPARENT);
        berekenMuis();
        setWidth(50);
    }



    @Override
    public void explicitUpdate(long l) {
        this.zaklampSwitch = gameScene.getZaklamp();
        if(!zaklampSwitch) {
            setFill(Color.TRANSPARENT);
        }
        else {setFill(Color.YELLOW);}
        mouseCoordinates = lamp.getMouseCoordinates();
        berekenMuis();
    }

    public void berekenMuis() {
        angle = angleTo(mouseCoordinates);
        var distance = distanceTo(mouseCoordinates);
        setRotate(angle);
        setHeight(distance * 2);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
