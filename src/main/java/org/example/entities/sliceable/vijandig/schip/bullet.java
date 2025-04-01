package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;


public class bullet extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {

    protected bullet(String resource, Coordinate2D initialLocation, int direction, int speed) {
        super(resource, initialLocation);
        setMotion(speed, direction);
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
