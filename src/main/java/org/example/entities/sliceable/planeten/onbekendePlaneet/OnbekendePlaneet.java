package org.example.entities.sliceable.planeten.onbekendePlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.entities.tools.zaklamp.ZaklampPunt;
import org.example.scenes.GameScene;

import java.util.List;

public class OnbekendePlaneet extends Planeet implements Collided {
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
        geslicedePlaneten++;
        gameScene.doeScoreErbij(-1);
        remove();
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof ZaklampPunt) {
                ZaklampPunt lampPunt = (ZaklampPunt) collider;
                double lampX = lampPunt.getMouseCoordinates().getX();
                double lampY = lampPunt.getMouseCoordinates().getY();
                double hitboxX = objectLocation.getX();
                double hitboxY = objectLocation.getY();
                double distance = Math.sqrt(Math.pow(lampX - hitboxX, 2) + Math.pow(lampY - hitboxY, 2));
                if(distance < 25) {
                    remove();
                    gameScene.setSceneOnbekend();
                }
            }
        }
    }
}
