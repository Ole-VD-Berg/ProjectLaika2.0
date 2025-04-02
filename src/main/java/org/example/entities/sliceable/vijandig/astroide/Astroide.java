package org.example.entities.sliceable.vijandig.astroide;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Astroide extends SliceableObject implements Collider { ;

    public Astroide(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);
        setMotion(SPEED, direction);

    }


    @Override
    protected void setupEntities() {
        super.setupEntities();
        AstroideSprite astroideSprite = new AstroideSprite("sprites/vijandig/astroide.png", new Coordinate2D(intitialLocation), new Size(size, size), 1, 4);
        addEntity(astroideSprite);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    protected void doSlicingActie() {
        remove();
    }
}

