package org.example.entities.laser;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.scenes.GameScene;

public class Laser extends DynamicCompositeEntity {


    private final GameScene gameScene;

    public Laser(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        this.gameScene = gameScene;

    }

    @Override
    protected void setupEntities() {
        LaserRect laserRect = new LaserRect(new Coordinate2D(0, 0), gameScene);
        addEntity(laserRect);
    }

}
