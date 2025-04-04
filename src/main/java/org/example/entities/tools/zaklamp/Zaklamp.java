package org.example.entities.tools.zaklamp;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import org.example.entities.tools.laser.LaserPunt;
import org.example.entities.tools.laser.LaserRect;
import org.example.scenes.GameScene;

public class Zaklamp extends DynamicCompositeEntity implements MouseMovedListener, MouseMovedWhileDraggingListener, UpdateExposer {

    private Coordinate2D mouseCoordinates;
    private GameScene gameScene;
    private ZaklampTriangle zaklampTriangle;
    private ZaklampPunt zaklampPunt;
    public Zaklamp(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        this.gameScene = gameScene;
        setViewOrder(14);
        this.mouseCoordinates = gameScene.getMouseCoordinates();
    }

    @Override
    protected void setupEntities() {
        zaklampTriangle  = new ZaklampTriangle(new Coordinate2D(0, 0), gameScene, this);
        addEntity(zaklampTriangle);
        zaklampPunt = new ZaklampPunt(new Coordinate2D(0, 0), gameScene, this);
        addEntity(zaklampPunt);

    }

    @Override
    public void onMouseMoved(Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
    }

    @Override
    public void onMouseMovedWhileDragging(Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
    }

    public Coordinate2D getMouseCoordinates() {
        return mouseCoordinates;
    }

    @Override
    public void explicitUpdate(long l) {

    }
    public void setRemove() {
        zaklampTriangle.remove();
        zaklampPunt.remove();
        this.remove();
    }
}
