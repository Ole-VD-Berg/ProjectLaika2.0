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

import java.util.Set;

public class TutorialScene extends DynamicScene implements TimerContainer,  KeyListener, MouseButtonPressedListener {
    private final GameScene gameScene;
    ProjectLaika game;
    TextSwitch textSwitch;
    TextTimer textTimer;
    TutorialSprite tutorialSprite;
    private boolean laser = false;
    private boolean zaklamp = false;
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
        Laser laser = new Laser(new Coordinate2D(getWidth() / 2, getHeight()), gameScene);
        addEntity(laser);
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
                case 3, 5, 6, 7, 11, 13, 14:
                    tutorialSprite.nieuweFrame();
                    break;
            }
        }
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mouseCoordinates = coordinate2D;
        if (mouseButton == MouseButton.PRIMARY) {
            zaklamp = false;
            laser = !laser;

        }
        else if (mouseButton == MouseButton.SECONDARY) {
            laser = false;
            zaklamp = !zaklamp;

        }

    }

}
