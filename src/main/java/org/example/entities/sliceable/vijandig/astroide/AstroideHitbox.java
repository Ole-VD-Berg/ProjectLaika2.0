package org.example.entities.sliceable.vijandig.astroide;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;
import org.example.entities.sliceable.vijandig.astroide.Astroide;
import org.example.entities.tools.laser.LaserPunt;
import org.example.scenes.GameScene;

import java.util.List;

public class AstroideHitbox extends DynamicCircleEntity implements Collided {

    private ProjectLaika game;
    private GameScene gameScene;
    private Astroide astroide;
    private int size;
    public boolean exit = false;
    private boolean wasInsideHitbox = false;

    public AstroideHitbox(Coordinate2D initialLocation, ProjectLaika game, Astroide astroide, GameScene gameScene, int size, int direction) {
        super(initialLocation);
        this.game = game;
        this.gameScene = gameScene;
        this.astroide = astroide;
        this.size = size;
        setRadius(this.size / 4);
        //^grootte van sprite is in werkelijkheid 2x zo groot als de sprite die je ziet daarom nog een keer /2
        setFill(Color.TRANSPARENT);
        if(direction == 315){
            setAnchorPoint(AnchorPoint.TOP_RIGHT);
    }
        else{
            setAnchorPoint(AnchorPoint.TOP_LEFT);
        }
        }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof LaserPunt laserPunt) {

                double laserX = laserPunt.getMouseCoordinates().getX();
                double laserY = laserPunt.getMouseCoordinates().getY();
                if(isInHitbox(laserX, laserY)) {
                    wasInsideHitbox = true;
                }
                if(!isInHitbox(laserX, laserY) && wasInsideHitbox){
                    exit = true;
                    wasInsideHitbox = false;
                }
            }
        }
    }

    private boolean isInHitbox(double laserX, double laserY) {
        double hitboxX = astroide.getPlaneetLocatie().getX();
        double hitboxY = astroide.getPlaneetLocatie().getY();
        double hitboxRadius = getRadius();
        double distance = Math.sqrt(Math.pow(laserX - hitboxX, 2) + Math.pow(laserY - hitboxY, 2));
        return distance <= hitboxRadius;
    }

    public boolean getExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
