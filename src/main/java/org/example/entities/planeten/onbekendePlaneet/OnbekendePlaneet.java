package org.example.entities.planeten.onbekendePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Hitbox;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbekendePlaneet extends Planeet {


    public OnbekendePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
    }
    protected void setupEntities() {
        super.setupEntities();
        OnbekendePlaneetSprite sprite = new OnbekendePlaneetSprite("sprites/planeten/overlays/onbekend.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);
    }
    @Override
    protected void doSlicingActie() {
        System.out.println("Onbekende planeet gesliced");
        gameScene.doeScoreErbij(1000);
        remove();
    }
}
