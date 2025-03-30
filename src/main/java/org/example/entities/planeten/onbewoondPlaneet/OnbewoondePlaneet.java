package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class OnbewoondePlaneet extends Planeet  {
    private Coordinate2D intitialLocation;
    private Coordinate2D test;
    private ProjectLaika game;
    private GameScene gameScene;
    private int size;
    public OnbewoondePlaneet(Coordinate2D initiallocation, int size, ProjectLaika game, GameScene gameScene) {
        super(initiallocation, size);
        this.intitialLocation = initiallocation;
        this.game = game;
        this.gameScene = gameScene;
        this.size = size;
        this.test = new Coordinate2D(0 - initiallocation.getX(), 0 - initiallocation.getY());
        System.out.println(test);

    }

    @Override
    public void setupEntities() {

        getPlaneetSprite(intitialLocation);
        OnbewoondePlaneetSprite sprite = new OnbewoondePlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(sprite);

        SchermHitBox schermHitBox = new SchermHitBox(new Coordinate2D(intitialLocation), game, this.test);
        addEntity(schermHitBox);


        HitBox hitBox = new HitBox(new Coordinate2D(intitialLocation), game, this.size);
        addEntity(hitBox);


    }
}
