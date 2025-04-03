package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;

public class Zwartgat extends SliceableObject implements Collider, UpdateExposer {
    Coordinate2D locatie;


    public Zwartgat(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        this.locatie = initialLocation;
        this.locatie = getLocationInScene();


    }


    @Override
    protected void setupEntities() {
        super.setupEntities();
        ZwartgatHitbox hitBox = new ZwartgatHitbox(new Coordinate2D(intitialLocation), game, this, gameScene, this.size);
        addEntity(hitBox);
        ZwartgatSprite zwartgatSprite = new ZwartgatSprite("sprites/vijandig/zwartgat.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(zwartgatSprite);


    }
    public Coordinate2D getPlaneetLocatie() {
        return locatie;
    }


    @Override
    protected void doSlicingActie() {
        remove();
    }
}

