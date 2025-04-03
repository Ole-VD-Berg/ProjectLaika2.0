package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.entities.tools.laser.LaserPunt;
import org.example.entities.tools.zaklamp.ZaklampPunt;
import org.example.scenes.GameScene;

import java.util.List;

public class Zwartgat extends SliceableObject implements UpdateExposer, Collided {
    Coordinate2D locatie;


    public Zwartgat(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        this.locatie = initialLocation;
        this.locatie = getLocationInScene();


    }


    @Override
    protected void setupEntities() {
        super.setupEntities();
        ZwartgatSprite zwartgatSprite = new ZwartgatSprite("sprites/vijandig/zwartgat.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(zwartgatSprite);


    }
    public Coordinate2D getPlaneetLocatie() {
        return locatie;
    }


    @Override
    protected void doSlicingActie() {
        remove();
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof ZaklampPunt) {
                ZaklampPunt lampPunt = (ZaklampPunt) collider;
                double lampX = lampPunt.getMouseCoordinates().getX();
                double lampY = lampPunt.getMouseCoordinates().getY();
                double distance = berekenAfstand(lampX, lampY);
                if(distance < 25) {
                    remove();
                }
            }
            if (collider instanceof LaserPunt) {
                LaserPunt laserPunt = (LaserPunt) collider;
                double laserX = laserPunt.getMouseCoordinates().getX();
                double laserY = laserPunt.getMouseCoordinates().getY();
                double distance = berekenAfstand(laserX, laserY);
                if(distance < 25) {
                    // Hier kun je de actie toevoegen die moet gebeuren als de laser het zwart gat raakt
                }
            }
        }
    }

    public double berekenAfstand(double x, double y) {
        double hitboxX = objectLocation.getX();
        double hitboxY = objectLocation.getY();
        return Math.sqrt(Math.pow(x - hitboxX, 2) + Math.pow(y - hitboxY, 2));
    }
}



