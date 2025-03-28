package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.userinput.*;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;

import java.util.List;

public class HitBox extends DynamicCircleEntity implements Collided, MouseExitListener, MouseDraggedListener  {

    private ProjectLaika game;
    int size;
    boolean isDragged = false;
    protected HitBox(Coordinate2D initialLocation, ProjectLaika game, int size) {
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
    public void onMouseExited() {
        checkForSlice();
    }

    @Override
    public void onDragged(Coordinate2D coordinate2D) {
        isDragged = true;
    }

    @Override
    public void onDropped(Coordinate2D coordinate2D) {
        isDragged = false;
    }

    private void checkForSlice() {
        System.out.println(":)");
        if (isDragged) {
            System.out.println("yay");
        }
    }
}
