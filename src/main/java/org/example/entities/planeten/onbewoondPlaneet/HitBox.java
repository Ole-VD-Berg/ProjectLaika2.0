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

public class HitBox extends DynamicCircleEntity implements Collided, MouseButtonPressedListener, MouseEnterListener, MouseExitListener, MouseButtonReleasedListener, UpdateExposer {

    private ProjectLaika game;
    int size;
    boolean isClicked = false;
    boolean isEntered = false;
    boolean isExited = false;
    boolean isDragged;
    SchermHitbox schermHitbox;
    int ding = 0;

    protected HitBox(Coordinate2D initialLocation, ProjectLaika game, int size, SchermHitbox isDragged) {
        super(initialLocation);
        this.game = game;
        this.size = size;
        setRadius(this.size / 4);
        //^grootte van sprite is in werkelijkheid 2x zo groot als de sprite die je ziet daarom nog een keer /2
        setFill(Color.TRANSPARENT);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void test() {
       schermHitbox  = new SchermHitbox(game);
    }

    @Override
    public void explicitUpdate(long l) {
        ding ++;
        if(ding == 1){
            test();
        }
        this.isDragged = schermHitbox.getIsDragged();
    }

    @Override
    public void onCollision(List<Collider> list) {
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        isClicked = true;
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        isClicked = false;
        isEntered = false;
        isExited = false;
    }

    @Override
    public void onMouseEntered() {

        isEntered = true;
    }

    @Override
    public void onMouseExited() {
        isExited = true;
        checkForSlice();
    }

    public void checkForSlice(){
        if (isDragged && isEntered && isExited) {
            game.setActiveScene(0);
        }
//        System.out.println(
//                "isDragged: " + isDragged
//                + ", isEntered: " + isEntered
//                + ", isExited: " + isExited
//        );
    }
}
