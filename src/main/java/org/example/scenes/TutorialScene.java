package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.onbekendePlaneet.OnbekendePlaneet;
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
    private boolean laserAan = false;
    private boolean zaklampAan = false;
    Coordinate2D mouseCoordinates = new Coordinate2D(0, 0);

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
        tutorialSprite = new TutorialSprite("backgrounds/overlays/spriteFrameTutorial.png", new Coordinate2D(getWidth() / 2, getHeight() / 2), new Size(getWidth(), getHeight()), 8, 1);
        addEntity(tutorialSprite);
        textSwitch = new TextSwitch(new Coordinate2D(getWidth() / 2, getHeight() / 12), game);
        addEntity(textSwitch);

    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.SPACE) && !textTimer.isActive()) {
            textSwitch.nieuweZin();
            textTimer.reset();
            textTimer.resume();

            switch(textSwitch.getZin()) {
                case 3, 5, 6, 7, 11:
                    tutorialSprite.nieuweFrame();
                    break;
                case 15:
                    tutorialSprite.nieuweFrame();
                    setupLaser();
                    break;
                case 17:
                    setupZaklamp();
                    break;
            }
        }
    }


    public void setupLaser(){
            laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), gameScene);
            addEntity(laser);
            System.out.println("laser aan");
    }

    public void setupZaklamp(){
            lamp = new Zaklamp(new Coordinate2D(getWidth() / 2, getHeight()), gameScene);
            addEntity(lamp);
            laser.setRemove();
        System.out.println("zaklamp");
    }
}
