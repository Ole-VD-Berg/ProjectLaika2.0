package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ZwartgatSprite extends DynamicSpriteEntity {

    protected ZwartgatSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns, int currentRow) {
        super(resource, initialLocation, size, rows, columns);
        setPreserveAspectRatio(true);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setAutoCycle(100, currentRow);
    }
}
