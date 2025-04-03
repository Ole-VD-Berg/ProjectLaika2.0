package org.example.entities.tools.laser;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.MouseMovedListener;
import com.github.hanyaeger.api.userinput.MouseMovedWhileDraggingListener;
import org.example.scenes.GameScene;

public class Laser extends DynamicCompositeEntity implements MouseMovedListener, MouseMovedWhileDraggingListener, UpdateExposer {

    private Coordinate2D mouseCoordinates;
    private  GameScene gameScene;
    private LaserRect laserRect;
    private LaserPunt laserPunt;
    public Laser(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        this.gameScene = gameScene;
        setViewOrder(14);
        this.mouseCoordinates = gameScene.getMouseCoordinates();
    }

    @Override
    protected void setupEntities() {
        laserRect = new LaserRect(new Coordinate2D(0, 0), gameScene, this);
        addEntity(laserRect);
        laserPunt = new LaserPunt(new Coordinate2D(0, 0), gameScene, this);
        addEntity(laserPunt);

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
        if(laserRect != null && laserPunt != null){
            laserRect.remove();
            laserPunt.remove();
            this.remove();
        }
    }
}
