package org.example.entities.laser;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Laser extends DynamicCompositeEntity implements UpdateExposer {


    private final Coordinate2D mouseCoordinates;

    public Laser(Coordinate2D initialLocation, Coordinate2D mouseCoordinates) {
        super(initialLocation);
        this.mouseCoordinates = mouseCoordinates;
    }

    @Override
    protected void setupEntities() {
        LaserRect laserRect = new LaserRect(new Coordinate2D(0, 0), new Size(10, 10), mouseCoordinates);
        addEntity(laserRect);
    }

    @Override
    public void explicitUpdate(long l) {
       // System.out.println("Mouse coordinates heere: " + mouseCoordinates);
    }
}
