package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.ProjectLaika;
import org.example.entities.titleScene.PlayButtonSprite;
import com.github.hanyaeger.api.Size;
import org.example.entities.titleScene.QuitButtonSprite;
import org.example.entities.titleScene.TutorialButtonSprite;

public class TitleScene extends StaticScene {
    private ProjectLaika game;
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
        PlayButtonSprite playButtonSprite = new PlayButtonSprite("sprites/titleScene/playButtonSpriteSheet.png", new Coordinate2D(getWidth() / 2 - 11, getHeight() / 2 + 12), new Size( 150), 2,1, game);
        addEntity(playButtonSprite);
        QuitButtonSprite quitButtonSprite = new QuitButtonSprite("sprites/titleScene/quitButtonSpriteSheet.png", new Coordinate2D(getWidth() / 2 + 50, getHeight() / 2 + 50), new Size( 35), 2,1, game);
        addEntity(quitButtonSprite);
        TutorialButtonSprite tutorial = new TutorialButtonSprite("sprites/titleScene/tutorialbutton.png", new Coordinate2D(getWidth() - 50, getHeight() - 50), new Size( 75), game);
        addEntity(tutorial);
        TutorialButtonSprite tutorialTextSprite = new TutorialButtonSprite("sprites/titleScene/tutorialTextSprite.png", new Coordinate2D(getWidth() * 0.83, getHeight() * 0.72), new Size(120,90), game);
        addEntity(tutorialTextSprite);
    }
}
