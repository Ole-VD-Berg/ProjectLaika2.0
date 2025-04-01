package org.example.entities.SpaceShip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.geometry.Bounds;

public class DamageHitbox extends RectangleEntity implements Collider {

    public DamageHitbox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
    }
}
