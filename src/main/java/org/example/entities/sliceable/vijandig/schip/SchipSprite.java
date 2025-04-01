package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

import java.util.Optional;

public class SchipSprite extends DynamicSpriteEntity implements MouseButtonPressedListener {

    protected SchipSprite(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
        setPreserveAspectRatio(true);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }

}
