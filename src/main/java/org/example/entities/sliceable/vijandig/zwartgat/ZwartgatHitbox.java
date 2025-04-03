package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;
import org.example.entities.tools.laser.LaserPunt;
import org.example.scenes.GameScene;

import java.util.List;

public class ZwartgatHitbox extends DynamicCircleEntity implements Collided {

    private ProjectLaika game;
    private GameScene gameScene;
    private Zwartgat zwartgat;
    int size;
    public boolean exit = false;
    private boolean wasInsideHitbox = false;

    public ZwartgatHitbox(Coordinate2D initialLocation, ProjectLaika game, Zwartgat zwartgat, GameScene gameScene, int size) {
        super(initialLocation);
        this.game = game;
        this.gameScene = gameScene;
        this.zwartgat = zwartgat;
        this.size = size;
        setRadius(this.size / 4);
        //^grootte van sprite is in werkelijkheid 2x zo groot als de sprite die je ziet daarom nog een keer /2
        setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
        double hitboxX = zwartgat.getPlaneetLocatie().getX();
        double hitboxY = zwartgat.getPlaneetLocatie().getY();
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
