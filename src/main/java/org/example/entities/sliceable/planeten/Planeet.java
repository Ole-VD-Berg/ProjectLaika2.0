package org.example.entities.sliceable.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.ProjectLaika;
import org.example.entities.overlays.SchermHitbox;
import org.example.entities.sliceable.planeten.SliceableObjecten;
import org.example.scenes.GameScene;

import java.util.Random;

public abstract class Planeet extends SliceableObjecten {
        protected int size;
        private static int geslicedePlaneten = 0;
        protected Hitbox hitBox;
        protected Coordinate2D intitialLocation;
        protected ProjectLaika game;
        protected GameScene gameScene;

    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
        double SPEED = new Random().nextDouble(1) + 1;
        setMotion(SPEED, direction);
    }
    public int getGeslicedePlaneten() {
        return geslicedePlaneten;
    }

    public void resetGeslicedePlaneten() {
        geslicedePlaneten = 0;
    }


}
