package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.ProjectLaika;
import org.example.entities.text.textSwitch.TextSwitch;
import org.example.entities.text.textSwitch.TextTimer;
import org.example.entities.text.textSwitch.TutorialSprite;
import org.example.entities.tools.laser.Laser;
import org.example.entities.tools.zaklamp.Zaklamp;

import java.util.Set;

public class TutorialScene extends DynamicScene implements TimerContainer,  KeyListener {
    private final GameScene gameScene;
    ProjectLaika game;
    TextSwitch textSwitch;
    TextTimer textTimer;
    TutorialSprite tutorialSprite;
    private Laser laser;
    private Zaklamp lamp;

    public TutorialScene(ProjectLaika game, GameScene gameScene) {
        this.game = game;
        this.gameScene = gameScene;
    }
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupTimers() {
        textTimer = new TextTimer(200);
        addTimer(textTimer);
    }

    @Override
    public void setupEntities() {
        tutorialSprite = new TutorialSprite("backgrounds/overlays/spriteFrameTutorial.png", new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(getWidth(), getHeight()), 9, 1);
        addEntity(tutorialSprite);
        textSwitch = new TextSwitch(new Coordinate2D(getWidth() / 2, getHeight() / 12), this);
        addEntity(textSwitch);

    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.SPACE) && !textTimer.isActive()) {
            textSwitch.nieuweZin();
            textTimer.reset();
            textTimer.resume();
            switch(textSwitch.getZin()) {
                case 3, 5, 6, 7, 11, 13, 15:
                    tutorialSprite.nieuweFrame();
                    break;
                case 17:
                    tutorialSprite.nieuweFrame();
                    setupLaser();
                    break;
                case 19:
                    setupZaklamp();
                    break;
                case  20:
                    gameScene.setZaklamp(false);
                case 21:
                    veranderScene();
            }


        }
    }


    public void setupLaser(){
        gameScene.setLaser(true);
        laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), gameScene);
        addEntity(laser);
    }

    public void setupZaklamp(){
        gameScene.setLaser(false);
        gameScene.setZaklamp(true);
            lamp = new Zaklamp(new Coordinate2D(getWidth() / 2, getHeight()), gameScene);
            addEntity(lamp);
    }
    public void veranderScene(){
        game.setActiveScene(0);
    }
}
