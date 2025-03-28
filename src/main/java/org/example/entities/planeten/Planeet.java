package org.example.entities.planeten;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import javafx.geometry.Point2D;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondPlaneetSprite;

    public class Planeet extends DynamicCompositeEntity {


        private int randomNummer;
        protected int size;
    public Planeet(Coordinate2D initiallocation, int size) {
        super(initiallocation);
        this.size = size;
        getRandomSprite();
    }

    @Override
    protected void setupEntities() {}

    protected void getPlaneetSprite( Coordinate2D initialLocation) {

        PlaneetSprite sprite = new PlaneetSprite("sprites/planeten/planeet" + randomNummer + ".png", new Coordinate2D(initialLocation), new Size(size, size));
        addEntity(sprite);

    }
    protected void getRandomSprite() {
        randomNummer = (int) (Math.random() * 8) + 1;
    }

}
