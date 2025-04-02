package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.*;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Schip extends SliceableObject  {
    private int direction;
    public Schip(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);
        //setMotion(SPEED, direction);

    }

//    public Coordinate2D getLocation() {
//        return getAnchorLocation();
//    }

    @Override
    protected void setupEntities() {
        super.setupEntities();
        SchipSprite schipSprite = new SchipSprite("sprites/vijandig/schip.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(schipSprite);
        SchipGun schipGun = new SchipGun( new Coordinate2D(intitialLocation), this);
        addEntity(schipGun);
    }

    @Override
    protected void doSlicingActie() {
        remove();
    }
}

