package org.example.entities.sliceable.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.scenes.GameScene;


public abstract class Planeet extends SliceableObject {
        private static int geslicedePlaneten = 0;

    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation, size, game, gameScene, direction);
        setMotion(SPEED, direction);
    }
    protected void setupEntities() {
        getPlaneetSprite(intitialLocation);
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


}
