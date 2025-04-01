package org.example.entities.tools;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.example.scenes.GameScene;

public class Zaklamp extends DynamicCompositeEntity{
    private final GameScene gameScene;

    public Zaklamp(Coordinate2D initialLocation, GameScene gameScene) {
        super(initialLocation);
        this.gameScene = gameScene;

    }



    @Override
    protected void setupEntities() {
        ZaklampTriangle zaklampTriangle = new ZaklampTriangle("backgrounds/overlays/gameOverlaySpritesheet.png", new Coordinate2D(0, 0), new Size(getWidth(), getHeight()), 3,1, gameScene);
        addEntity(zaklampTriangle);
    }


}
