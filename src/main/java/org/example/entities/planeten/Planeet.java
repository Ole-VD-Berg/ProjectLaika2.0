package org.example.entities.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.ProjectLaika;
import org.example.entities.overlays.SchermHitbox;
import org.example.scenes.GameScene;

import java.util.Random;

public abstract class Planeet extends DynamicCompositeEntity implements UpdateExposer, SceneBorderCrossingWatcher {
        protected int size;
        private static int geslicedePlaneten = 0;
        protected Hitbox hitBox;
        protected SchermHitbox schermHitbox;
        protected Coordinate2D intitialLocation;
        protected ProjectLaika game;
        protected GameScene gameScene;

    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation);
        this.size = size;
        this.intitialLocation = initiallocation;
        this.game = game;
        this.gameScene = gameScene;
        this.schermHitbox = gameScene.schermHitbox;
        double SPEED = new Random().nextDouble(1) + 1;
        setMotion(SPEED, direction);
    }

    @Override
    protected void setupEntities() {
        getPlaneetSprite(intitialLocation);

        hitBox = new Hitbox(new Coordinate2D(intitialLocation), game, this.size, gameScene);
        addEntity(hitBox);
    }

    protected void getPlaneetSprite( Coordinate2D initialLocation) {
        PlaneetSprite sprite = new PlaneetSprite("sprites/planeten/planeet" + getRandomSprite() + ".png", new Coordinate2D(initialLocation), new Size(size, size));
        addEntity(sprite);
    }

    protected int getRandomSprite() {
        return (int) (Math.random() * 8) + 1;
    }

    @Override
    public void explicitUpdate(long l) {
        if(hitBox != null) {
            checkForSlice();
        }

    }

    public void checkForSlice(){
        if(!gameScene.getLaser()){
            hitBox.setExit(false);
        }
        if(hitBox.getExit() && gameScene.getLaser()){
            doSlicingActie();
            geslicedePlaneten++;
        }

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

    protected abstract void doSlicingActie();

    public int getGeslicedePlaneten() {
        return geslicedePlaneten;
    }

    public void resetGeslicedePlaneten() {
        geslicedePlaneten = 0;
    }
}
