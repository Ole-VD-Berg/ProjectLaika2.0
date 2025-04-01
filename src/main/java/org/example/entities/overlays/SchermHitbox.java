package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;

public class SchermHitbox extends RectangleEntity implements MouseDraggedListener {

    private boolean isDragged = false;
    public SchermHitbox(Coordinate2D initialLocation, ProjectLaika game) {
        super(initialLocation);
        setWidth(game.getWidth());
        setHeight(game.getHeight());
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onDragged(Coordinate2D coordinate2D) {
        isDragged = true;
    }

    @Override
    public void onDropped(Coordinate2D coordinate2D) {
        isDragged = false;
    }

    public boolean getIsDragged() {
        return isDragged;
    }
}
