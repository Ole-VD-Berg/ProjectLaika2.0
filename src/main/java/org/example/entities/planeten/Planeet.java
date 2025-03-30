package org.example.entities.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Planeet extends DynamicCompositeEntity {


        private int randomNummer;
        protected int size;
    public Planeet(Coordinate2D initiallocation, int size) {
        super(initiallocation);
        this.size = size;
        getRandomSprite();
    }

    @Override
 protected void setupEntities() {
//        OnbewoondPlaneet onbewoondePlaneet = new OnbewoondPlaneet(innitialLocation, size, g, null);
//        addEntity(onbewoondePlaneet);
    }

    protected void getPlaneetSprite( Coordinate2D initialLocation) {

        PlaneetSprite sprite = new PlaneetSprite("sprites/planeten/planeet" + randomNummer + ".png", new Coordinate2D(initialLocation), new Size(size, size));
        addEntity(sprite);

    }
    protected void getRandomSprite() {
        randomNummer = (int) (Math.random() * 8) + 1;
    }

}
