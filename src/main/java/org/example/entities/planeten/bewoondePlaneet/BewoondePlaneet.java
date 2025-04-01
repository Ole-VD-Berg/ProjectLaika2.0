package org.example.entities.planeten.bewoondePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class BewoondePlaneet extends Planeet {

    public BewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
    }


    protected void setupEntities() {
        super.setupEntities();
        BewoondePlaneetSprite sprite = new BewoondePlaneetSprite("sprites/planeten/overlays/bewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);
    }

    @Override
    protected void doSlicingActie() {
        remove();
    }
}
