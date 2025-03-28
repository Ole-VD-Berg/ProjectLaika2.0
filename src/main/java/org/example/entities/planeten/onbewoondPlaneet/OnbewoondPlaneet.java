package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.example.ProjectLaika;
import org.example.entities.planeten.Planeet;
import org.example.entities.planeten.PlaneetSprite;

public class OnbewoondPlaneet extends Planeet{
    private Coordinate2D intitialLocation;
    private ProjectLaika game;
    private int size;
    private boolean isDragged;
    public OnbewoondPlaneet(Coordinate2D initiallocation, int size, ProjectLaika game) {
        super(initiallocation, size);
        this.intitialLocation = initiallocation;
        this.game = game;
        this.size = size;

    }

    @Override
    public void setupEntities() {

        getPlaneetSprite(intitialLocation);
        OnbewoondPlaneetSprite sprite = new OnbewoondPlaneetSprite("sprites/planeten/overlays/onbewoond.png", new Coordinate2D(intitialLocation) , new Size(size, size));
        addEntity(sprite);


        HitBox hitBox = new HitBox(new Coordinate2D(intitialLocation), game, this.size);
        addEntity(hitBox);


    }
}
