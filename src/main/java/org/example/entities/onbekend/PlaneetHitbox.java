package org.example.entities.onbekend;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlaneetHitbox extends CircleEntity implements MouseButtonPressedListener {
    public boolean planeetKlick = false;
    public PlaneetHitbox(Coordinate2D initialLocation, int size) {
        super(initialLocation);
        setRadius(size / 4);
        setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setViewOrder(-1);
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        planeetKlick = true;
    }

    public boolean getPlaneetKlick() {
        return planeetKlick;
    }
}
