package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class RandomSprite extends SpriteEntity {
    protected RandomSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
