package org.example.entities.sliceable.vijandig.astroide;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class AstroideSprite extends SpriteEntity {

    protected AstroideSprite(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setPreserveAspectRatio(true);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
