package org.example.entities.SpaceShip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.geometry.Bounds;
import org.example.entities.sliceable.vijandig.schip.Bullet;
import org.example.entities.tools.laser.LaserPunt;

import java.util.List;

public class DamageHitbox extends RectangleEntity implements Collided {

    public DamageHitbox(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Bullet) {


            }
        }
    }
}
