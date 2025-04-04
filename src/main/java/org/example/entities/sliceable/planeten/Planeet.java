package org.example.entities.sliceable.planeten;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;


public abstract class Planeet extends SliceableObject implements UpdateExposer {
        protected static int geslicedePlaneten = 0;
        protected int planeetNr;


    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setMotion(SPEED, direction);
    }

    protected void setupEntities() {
        getPlaneetSprite(intitialLocation);
        super.setupEntities();
    }

    protected void getPlaneetSprite( Coordinate2D initialLocation) {
        planeetNr = getRandomSprite();
        PlaneetSprite sprite = new PlaneetSprite("sprites/planeten/planeet" + planeetNr + ".png", new Coordinate2D(initialLocation), new Size(size, size));
        addEntity(sprite);
    }

    protected int getRandomSprite() {
        return (int) (Math.random() * 8) + 1;
    }

    public int getGeslicedePlaneten() {
        return geslicedePlaneten;
    }

    public void resetGeslicedePlaneten() {
        geslicedePlaneten = 0;
    }

    @Override
    public void explicitUpdate(long l) {
        super.explicitUpdate(l);
        if(!gameScene.getLaser()){
            hitBox.setExit(false);
        }
    }
}
