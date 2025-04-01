package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class Bullet extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    protected Bullet(String resource, Coordinate2D initialLocation, int direction, int speed) {
        super(resource, initialLocation);
        setMotion(speed, direction);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
