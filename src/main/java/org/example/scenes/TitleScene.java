package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.ProjectLaika;
import org.example.entities.buttons.QuitButton;
import org.example.entities.buttons.StartButton;

public class TitleScene extends StaticScene {
    private ProjectLaika game;
    private final int buttonX = 30;
    //private final int buttonY = (int) getHeight();
    public TitleScene(ProjectLaika game) {
        this.game = game;
    }


    @Override
    public void setupScene() {

       setBackgroundImage("backgrounds/backgroundUpscale.png");

    }

    @Override
    public void setupEntities() {
       // var TitleText
        StartButton startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), game);
        addEntity(startButton);
        QuitButton quitButton = new QuitButton(new Coordinate2D(buttonX, getHeight() - 25), game);
        addEntity(quitButton);
    }
}
