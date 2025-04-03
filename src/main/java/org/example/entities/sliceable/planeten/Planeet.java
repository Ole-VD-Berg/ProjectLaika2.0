package org.example.entities.sliceable.planeten;


import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;


public abstract class Planeet extends SliceableObject implements UpdateExposer {
        private static int geslicedePlaneten = 0;
        protected Coordinate2D planeetLocation;


    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.planeetLocation = initiallocation;
        this.planeetLocation = getLocationInScene();
        setMotion(SPEED, direction);
    }

    protected void setupEntities() {
        getPlaneetSprite(intitialLocation);
        hitBox = new Hitbox(new Coordinate2D(intitialLocation), game, this, gameScene, this.size);
        addEntity(hitBox);
        super.setupEntities();
    }

    protected void getPlaneetSprite( Coordinate2D initialLocation) {
        PlaneetSprite sprite = new PlaneetSprite("sprites/planeten/planeet" + getRandomSprite() + ".png", new Coordinate2D(initialLocation), new Size(size, size));
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
        this.planeetLocation = getLocationInScene();
        if(!gameScene.getLaser()){
            hitBox.setExit(false);
        }
    }

    public Coordinate2D getPlaneetLocation() {
        return planeetLocation;
    }


}
