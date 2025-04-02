package org.example.entities.sliceable.planeten.bewoondePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Hitbox;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.scenes.GameScene;

public class BewoondePlaneet extends Planeet {
    public BewoondePlaneet(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);

    }


    protected void setupEntities() {
        System.out.println(intitialLocation);
        super.setupEntities();

        BewoondePlaneetSprite sprite = new BewoondePlaneetSprite("sprites/planeten/overlays/bewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);

//        hitBox = new Hitbox(new Coordinate2D(intitialLocation), game, this, gameScene, this.size);
//        addEntity(hitBox);
    }

    @Override
    protected void doSlicingActie() {
        remove();
    }
}
