package org.example.entities.overlays;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;


public class OverlaySprite extends DynamicSpriteEntity {
    public OverlaySprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setCurrentFrameIndex(0);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setViewOrder(11);
    }
    public void increaseSpriteFrame() {
        setCurrentFrameIndex(getCurrentFrameIndex() + 1);
    }
}
