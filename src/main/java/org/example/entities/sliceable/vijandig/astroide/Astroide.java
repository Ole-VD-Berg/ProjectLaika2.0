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
        super(initialLocation, size, game, gameScene);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.currentRow = currentRow;
        this.locatie = initialLocation;
        this.locatie = getLocationInScene();
        this.direction = direction;
        setMotion(SPEED, direction);


    }

    @Override
    protected void setupEntities() {
        astroideHitbox = new AstroideHitbox(new Coordinate2D(intitialLocation), game, this, gameScene, this.size, direction);
        addEntity(astroideHitbox);
        AstroideSprite astroideSprite = new AstroideSprite("sprites/vijandig/astroideSpriteSheet.png", new Coordinate2D(intitialLocation), new Size(size, size), 2, 4, currentRow);
        addEntity(astroideSprite);
        super.setupEntities();


    }
    @Override
    public void explicitUpdate(long l) {
        super.explicitUpdate(l);
        this.locatie = getLocationInScene();
        if(!gameScene.getLaser()){
            astroideHitbox.setExit(false);
        }
    }
    public Coordinate2D getPlaneetLocatie() {
        return locatie;
    }


    @Override
    protected void doSlicingActie() {
        remove();
        System.out.println("Astroide gesliced");
    }
}

