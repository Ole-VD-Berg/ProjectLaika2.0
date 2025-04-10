package org.example.entities.onbekend;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class PlaneetSprite extends SpriteEntity {

    public PlaneetSprite(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
