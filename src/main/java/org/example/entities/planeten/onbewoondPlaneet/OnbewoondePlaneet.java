package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbewoondePlaneet extends Planeet {

    public OnbewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene) {
        super(initiallocation, size, game, gameScene);
    }


    protected void setupEntities() {
        setupyEntities();

        OnbewoondePlaneetSprite sprite = new OnbewoondePlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);

        hitBox = new HitBox(new Coordinate2D(intitialLocation), game, this.size);
        addEntity(hitBox);

    }
}
