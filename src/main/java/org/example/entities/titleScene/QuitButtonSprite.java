package org.example.entities.titleScene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;

public class QuitButtonSprite extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private ProjectLaika game;
    public QuitButtonSprite(String resource, Coordinate2D initialLocation, Size size, ProjectLaika game) {
        super(resource, initialLocation, size);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setPreserveAspectRatio(true);
        this.game = game;
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.quit();
    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
}
