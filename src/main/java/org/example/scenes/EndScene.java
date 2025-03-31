package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.ProjectLaika;
import org.example.entities.overlays.OverlaySprite;
import org.example.entities.overlays.ScoreText;
import org.example.entities.overlays.TimerText;
import org.example.entities.titleScene.PlayButtonSprite;
import org.example.entities.titleScene.QuitButtonSprite;

public class EndScene extends StaticScene {
    private ProjectLaika game;
    private final int buttonX = 30;
    //private final int buttonY = (int) getHeight();
    public EndScene(ProjectLaika game) {
        this.game = game;
    }


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
       // var TitleText
        PlayButtonSprite playButtonSprite = new PlayButtonSprite("sprites/titleScene/retryButtonSpriteSheet.png", new Coordinate2D(getWidth() / 2 - 100, getHeight() / 2 - 40), new Size( 150), 2,1, game);
        addEntity(playButtonSprite);
        QuitButtonSprite quitButtonSprite = new QuitButtonSprite("sprites/titleScene/quitButtonSpriteSheet.png", new Coordinate2D(getWidth() / 2 + 50, getHeight() / 2 + 50), new Size( 35), 2,1, game);
        addEntity(quitButtonSprite);
        OverlaySprite overlaySprite = new OverlaySprite("backgrounds/overlays/gameOverlayCrack1.png", new Coordinate2D(0, 0), new Size(getWidth(), getHeight()));
        addEntity(overlaySprite);
        ScoreText scoreText = new ScoreText(new Coordinate2D(390, getHeight() - 32));
        addEntity(scoreText);
        TimerText timerText = new TimerText(new Coordinate2D(278, getHeight() - 32));
        addEntity(timerText);
    }
}
