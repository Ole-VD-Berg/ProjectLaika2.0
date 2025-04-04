package org.example.entities.sliceable.planeten.onbewoondePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbewoondePlaneet extends Planeet {
    public OnbewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
    }


    protected void setupEntities() {
        super.setupEntities();

        OnbewoondePlaneetSprite sprite = new OnbewoondePlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);
    }

    protected void doSlicingActie() {
        gameScene.doeScoreErbij(1);
        remove();
        geslicedePlaneten++;
    }
}
