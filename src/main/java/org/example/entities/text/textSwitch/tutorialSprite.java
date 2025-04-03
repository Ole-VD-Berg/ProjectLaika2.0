package org.example.entities.text.textSwitch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class tutorialSprite extends DynamicSpriteEntity {

    protected tutorialSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }
    public void nieuweFrame() {
        setCurrentFrameIndex(getCurrentFrameIndex() + 1);
    }
}
