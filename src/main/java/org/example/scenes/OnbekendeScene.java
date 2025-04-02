package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.onbekend.PlaneetSprite;
import org.example.entities.onbekend.maan.Maan;

import java.util.Random;

public class OnbekendeScene extends DynamicScene implements MouseButtonPressedListener, EntitySpawnerContainer {
    ProjectLaika game;
    GameScene gameScene;
    private String planeet = "planeet" + new Random().nextInt(9);;
    public OnbekendeScene(ProjectLaika game, GameScene gameScene) {
        this.game = game;
        this.gameScene = gameScene;
    }


    @Override
    public void setupEntitySpawners() {

    }

    @Override
    public void setupScene( ) {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        PlaneetSprite planeetSprite = new PlaneetSprite("sprites/planeten/" + planeet + ".png", new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(500, 500));
        addEntity(planeetSprite);

        Maan maan = new Maan(new Coordinate2D(getWidth() / 2, getHeight() / 2), game);
        addEntity(maan);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
}
