package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.paint.Color;

public class MaanHitbox extends CircleEntity {
    protected MaanHitbox(Coordinate2D initialLocation, int size) {
        super(initialLocation);
        //setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setRadius(size / 4);
    }
}
