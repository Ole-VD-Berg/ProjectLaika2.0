package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import org.example.ProjectLaika;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbewoondePlaneet extends Planeet implements UpdateExposer {
    private Coordinate2D intitialLocation;
    private Coordinate2D test;
    private ProjectLaika game;
    private GameScene gameScene;
    private int size;
    private HitBox hitBox;
    private SchermHitBox schermHitBox;
    public OnbewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene) {
        super(initiallocation, size);
        this.intitialLocation = initiallocation;
        this.game = game;
        this.gameScene = gameScene;
        this.size = size;
        this.test = new Coordinate2D(0 - initiallocation.getX(), 0 - initiallocation.getY());
        setupEntities();
    }

    @Override
    public void setupEntities() {
        getPlaneetSprite(intitialLocation);
        OnbewoondePlaneetSprite sprite = new OnbewoondePlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);

        schermHitBox = new SchermHitBox(new Coordinate2D(intitialLocation), game, this.test);
        addEntity(schermHitBox);

        hitBox = new HitBox(new Coordinate2D(intitialLocation), game, this.size);
        addEntity(hitBox);
    }

    @Override
    public void explicitUpdate(long l) {
        if(hitBox != null && schermHitBox != null){
            checkForSlice();
        }


    }

    public void checkForSlice(){
        if(hitBox.getExit() && schermHitBox.getIsDragged()){
            game.setActiveScene(2);
        }

    }
}
