package org.example.entities.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.example.ProjectLaika;
import org.example.entities.overlays.SchermHitBox;
import org.example.scenes.GameScene;

public class Planeet extends DynamicCompositeEntity implements UpdateExposer {
        protected int size;
        protected HitBox hitBox;
        protected SchermHitBox schermHitBox;
        protected Coordinate2D intitialLocation;
        protected ProjectLaika game;
        protected GameScene gameScene;

    public Planeet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene) {
        super(initiallocation);
        this.size = size;
        this.intitialLocation = initiallocation;
        this.game = game;
        this.gameScene = gameScene;
        this.schermHitBox = gameScene.schermHitBox;

    }

    @Override
    protected void setupEntities() {

    }

    protected void setupyEntities() {
        getPlaneetSprite(intitialLocation);

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
        if(hitBox != null && schermHitBox != null) {
            checkForSlice();
        }
    }

    public void checkForSlice(){
        if(hitBox.getExit() && schermHitBox.getIsDragged()){
            game.setActiveScene(2);
        }

    }
}
