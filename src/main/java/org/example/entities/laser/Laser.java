package org.example.entities.laser;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Laser extends DynamicCompositeEntity {


    protected Laser(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        LaserRect laserRect = new LaserRect(new Coordinate2D(0, 0), new Size(10, 10));
        addEntity(laserRect);
    }
}
