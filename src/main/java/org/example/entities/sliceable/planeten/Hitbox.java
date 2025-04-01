package org.example.entities.sliceable.planeten;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;

import java.util.List;

public class Hitbox extends DynamicCircleEntity implements Collided, MouseDragExitedListener, MouseExitListener {

    private ProjectLaika game;
    int size;
    public boolean exit = false;
    public Hitbox(Coordinate2D initialLocation, ProjectLaika game, int size) {
        super(initialLocation);
        this.game = game;
        this.size = size;
        setRadius(this.size / 4);
        //^grootte van sprite is in werkelijkheid 2x zo groot als de sprite die je ziet daarom nog een keer /2
        setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onCollision(List<Collider> list) {
    }

    @Override
    public void onDragExited(Coordinate2D coordinate2D, MouseDraggedListener mouseDraggedListener) {
        exit = true;
    }

    public boolean getExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public void onMouseExited() {
        exit = false;
    }
}
