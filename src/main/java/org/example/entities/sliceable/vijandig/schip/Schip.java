package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.*;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Schip extends SliceableObject implements UpdateExposer  {
    private final ObjectenSpawner objectenSpawner;
    BulletSpawner bulletSpawner;
    public Schip(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction, ObjectenSpawner objectenSpawner) {
        super(initialLocation, size, game, gameScene, direction);
        setMotion(SPEED, direction);
        bulletSpawner = gameScene.getBulletSpawner();
        this.objectenSpawner = objectenSpawner;
    }

    @Override
    protected void setupEntities() {
        SchipSprite schipSprite = new SchipSprite("sprites/vijandig/schip.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(schipSprite);
        super.setupEntities();
    }
    @Override
    public void explicitUpdate(long l) {
        super.explicitUpdate(l);
        int direction = (int) angleTo(gameScene.getDamageHitbox());
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        bulletSpawner.setCoordinates(getLocationInScene());
        bulletSpawner.setDirection(direction);
    }

    @Override
    protected void doSlicingActie() {
        objectenSpawner.setSchipNaarNull();
        remove();
    }
}

