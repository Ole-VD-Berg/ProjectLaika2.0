package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Hitbox;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbewoondePlaneet extends Planeet {
    //int test = 1;
    public OnbewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
    }


    protected void setupEntities() {
        setupyEntities();

        OnbewoondePlaneetSprite sprite = new OnbewoondePlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);

        hitBox = new Hitbox(new Coordinate2D(intitialLocation), game, this.size);
        addEntity(hitBox);
    }

    protected void doSlicingActie() {
        gameScene.doeScoreErbij(1);
        remove();
    }
}
