package org.example.entities.sliceable;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Hitbox;
import org.example.scenes.GameScene;

import java.util.Random;

public abstract class SliceableObject extends DynamicCompositeEntity implements UpdateExposer, SceneBorderCrossingWatcher {
    protected int size;
    private static int geslicedePlaneten = 0;
    protected Hitbox hitBox;
    protected Coordinate2D intitialLocation;
    protected ProjectLaika game;
    protected GameScene gameScene;
    protected Coordinate2D initialLocation;
    protected double SPEED = new Random().nextDouble(1) + 1;
    public SliceableObject(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initiallocation);
        this.size = size;
        this.intitialLocation = initiallocation;
        this.game = game;
        this.gameScene = gameScene;
        double SPEED = new Random().nextDouble(1) + 1;
    }

    @Override
    protected void setupEntities() {

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


}
