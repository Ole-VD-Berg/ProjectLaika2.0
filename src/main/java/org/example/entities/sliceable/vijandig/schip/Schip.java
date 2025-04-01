package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;

import com.google.inject.Injector;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Schip extends SliceableObject {
    BulletSpawner spawner;
    public Schip(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction, BulletSpawner spawner) {
        super(initialLocation, size, game, gameScene, direction);
        //setMotion(SPEED, direction);
        this.spawner = spawner;
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
        spawner.setDirection(direction);
    }



}
