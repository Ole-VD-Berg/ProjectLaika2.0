package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class OverlaySprite extends SpriteEntity {
    public OverlaySprite(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}
