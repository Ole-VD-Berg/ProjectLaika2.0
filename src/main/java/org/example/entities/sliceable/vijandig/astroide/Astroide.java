package org.example.entities.sliceable.vijandig.astroide;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Astroide extends SliceableObject implements UpdateExposer, Collider {
    protected int direction;
    Coordinate2D locatie;
    private int currentRow;

    public Astroide(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction, int currentRow) {
        super(initialLocation, size, game, gameScene, direction);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.currentRow = currentRow;
        this.locatie = initialLocation;
        this.locatie = getLocationInScene();
        this.direction = direction;
        setMotion(SPEED, direction);


    }

    @Override
    protected void setupEntities() {
        AstroideSprite astroideSprite = new AstroideSprite("sprites/vijandig/astroideSpriteSheet.png", new Coordinate2D(intitialLocation), new Size(size, size), 2, 4, currentRow);
        addEntity(astroideSprite);
        super.setupEntities();


    }
    @Override
    public void explicitUpdate(long l) {
        super.explicitUpdate(l);
        this.locatie = getLocationInScene();
    }
    public Coordinate2D getPlaneetLocatie() {
        return locatie;
    }


    @Override
    protected void doSlicingActie() {
        gameScene.doeScoreErbij(1);
        remove();
    }
}

