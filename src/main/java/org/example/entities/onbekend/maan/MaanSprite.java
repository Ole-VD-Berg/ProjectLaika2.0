package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class MaanSprite extends DynamicSpriteEntity  {
    public MaanSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setPreserveAspectRatio(true);
    }
}
