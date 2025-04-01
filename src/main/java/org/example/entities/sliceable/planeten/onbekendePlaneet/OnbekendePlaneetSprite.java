package org.example.entities.sliceable.planeten.onbekendePlaneet;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class OnbekendePlaneetSprite extends SpriteEntity {

    protected OnbekendePlaneetSprite(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setPreserveAspectRatio(true);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
