package org.example.entities.vijandig;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.ProjectLaika;
import org.example.entities.overlays.SchermHitbox;
import org.example.entities.planeten.Hitbox;
import org.example.scenes.GameScene;

import java.util.Random;

public abstract class Astroide extends DynamicCompositeEntity implements UpdateExposer, SceneBorderCrossingWatcher {
        protected int size;
        protected Hitbox hitbox;
        protected SchermHitbox schermHitbox;
        protected Coordinate2D intitialLocation;
        protected ProjectLaika game;
        protected GameScene gameScene;

    public Astroide(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
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
    }

    protected void setupyEntities() {
        getPlaneetSprite(intitialLocation);
    }

    protected void getPlaneetSprite( Coordinate2D initialLocation) {
        AstroideSprite sprite = new AstroideSprite("sprites/titleScene/playButton.png", new Coordinate2D(initialLocation), new Size(size, size));
        addEntity(sprite);
    }

    @Override
    public void explicitUpdate(long l) {
        size++;
        //System.out.println(size);
        if(hitbox != null && schermHitbox != null) {
            checkForSlice();
        }

    }

    public void checkForSlice(){
        if(hitbox.getExit() && schermHitbox.getIsDragged()){
            doSlicingActie();
        }

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

    protected abstract void doSlicingActie();
}
