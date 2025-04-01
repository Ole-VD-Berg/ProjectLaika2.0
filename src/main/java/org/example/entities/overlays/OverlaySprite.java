package org.example.entities.overlays;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.example.ProjectLaika;


public class OverlaySprite extends DynamicSpriteEntity {
    public OverlaySprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setCurrentFrameIndex(2);

    }
    public void setSpriteFrame(int frame){
        setCurrentFrameIndex(frame);
    }
}
