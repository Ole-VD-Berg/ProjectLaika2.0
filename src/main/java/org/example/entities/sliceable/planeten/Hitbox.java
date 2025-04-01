package org.example.entities.sliceable.planeten;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;
import org.example.entities.tools.laser.LaserPunt;
import org.example.scenes.GameScene;

import java.util.List;

public class Hitbox extends DynamicCircleEntity implements Collided, MouseDragExitedListener, MouseExitListener {

    private ProjectLaika game;
    private GameScene gameScene;
    int size;
    public boolean exit = false;
    private boolean wasInsideHitbox = false;
    public Hitbox(Coordinate2D initialLocation, ProjectLaika game, int size, GameScene gameScene) {
        super(initialLocation);
        this.game = game;
        this.gameScene = gameScene;
        this.size = size;
        setRadius(this.size / 4);
        //^grootte van sprite is in werkelijkheid 2x zo groot als de sprite die je ziet daarom nog een keer /2
        setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof LaserPunt) {
            }
        }
    }

    @Override
    public void onDragExited(Coordinate2D coordinate2D, MouseDraggedListener mouseDraggedListener) {
        exit = true;
    }

    @Override
    public void onMouseExited() {
        exit = true;
    }

    public boolean getExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
