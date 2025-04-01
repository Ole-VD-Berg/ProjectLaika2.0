package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Schip extends SliceableObject {
    public Schip(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);
        //setMotion(SPEED, direction);
    }

    @Override
    protected void setupEntities() {
        super.setupEntities();
        SchipSprite schipSprite = new SchipSprite("sprites/vijandig/schip.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(schipSprite);
    }

    @Override
    protected void doSlicingActie() {
        remove();
    }


    private void schiet(int direction){
        new bullet("sprites/vijandig/bullet.png", new Coordinate2D(intitialLocation), direction, 10);
    }
}
