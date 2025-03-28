package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.ProjectLaika;
import org.example.entities.buttons.StartButton;
import org.example.entities.planeten.onbewoondPlaneet.OnbewoondPlaneet;

public class GameScene extends DynamicScene {
    private ProjectLaika game;

    public GameScene(ProjectLaika game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        OnbewoondPlaneet O1 = new OnbewoondPlaneet(new Coordinate2D(100,100) ,200, game);
        addEntity(O1);

    }
}
