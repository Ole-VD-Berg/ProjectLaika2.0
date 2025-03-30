package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseDraggedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.buttons.StartButton;
import org.example.entities.laser.Laser;
import org.example.entities.laser.LaserRect;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondPlaneet;

public class GameScene extends DynamicScene implements MouseButtonPressedListener, UpdateExposer {
    private ProjectLaika game;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);
    public GameScene(ProjectLaika game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        OnbewoondPlaneet O1 = new OnbewoondPlaneet(new Coordinate2D(100,100) ,200, game, this);
        addEntity(O1);
        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight() / 2), mouseCoordinates);
        addEntity(laser);

    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;

    }

    @Override
    public void explicitUpdate(long l) {
        System.out.println("Mouse coordinatess: " + mouseCoordinates);
    }
}
