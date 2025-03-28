package org.example.entities.planeten.onbewoondPlaneet;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;

public class SchermHitbox extends RectangleEntity implements MouseButtonPressedListener, MouseButtonReleasedListener {
    private ProjectLaika game;
    private boolean isDragged = false;
    public SchermHitbox(ProjectLaika game) {
        super(new Coordinate2D());

        this.game = game;
        setWidth(game.getWidth());
        setHeight(game.getHeight());
        setFill(Color.RED);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        isDragged = true;
        System.out.println(isDragged);
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        isDragged = false;
        System.out.println(isDragged);
    }

    public boolean getIsDragged() {
        System.out.println("test" + isDragged);
        return isDragged;
          }


}
