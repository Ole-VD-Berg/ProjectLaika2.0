package org.example.entities.sliceable.planeten.bewoondePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Hitbox;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.scenes.GameScene;

public class BewoondePlaneet extends Planeet {
    GameScene gameScene;
    public BewoondePlaneet(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);
        this.gameScene = gameScene;
    }


    protected void setupEntities() {
        System.out.println(intitialLocation);
        super.setupEntities();

        BewoondePlaneetSprite sprite = new BewoondePlaneetSprite("sprites/planeten/overlays/bewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);
    }

    @Override
    protected void doSlicingActie() {
        gameScene.doeScoreErbij(-2);
        remove();
        geslicedePlaneten++;
        remove();

    }
}
