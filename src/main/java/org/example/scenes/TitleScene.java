package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.ProjectLaika;
import org.example.entities.buttons.QuitButton;
import org.example.entities.titleScene.PlayButtonSprite;
import com.github.hanyaeger.api.Size;
import org.example.entities.titleScene.QuitButtonSprite;

public class TitleScene extends StaticScene {
    private ProjectLaika game;
    private final int buttonX = 30;
    //private final int buttonY = (int) getHeight();
    public TitleScene(ProjectLaika game) {
        this.game = game;
    }


    @Override
    public void setupScene() {
       setBackgroundImage("backgrounds/startScherm2.png");
    }

    @Override
    public void setupEntities() {
       // var TitleText
        PlayButtonSprite playButtonSprite = new PlayButtonSprite("sprites/titleScene/playButton.png", new Coordinate2D(getWidth() / 2 - 11, getHeight() / 2 + 12), new Size( 150), game);
        addEntity(playButtonSprite);
        QuitButtonSprite quitButtonSprite = new QuitButtonSprite("sprites/titleScene/quitButton.png", new Coordinate2D(getWidth() / 2 + 50, getHeight() / 2 + 50), new Size( 35), game);
        addEntity(quitButtonSprite);
    }
}
