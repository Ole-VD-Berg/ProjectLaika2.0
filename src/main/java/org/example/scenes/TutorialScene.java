package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.onbekendePlaneet.OnbekendePlaneet;
import org.example.entities.text.textSwitch.TextSwitch;
import org.example.entities.text.textSwitch.TextTimer;

import java.util.Set;

public class TutorialScene extends DynamicScene implements TimerContainer,  KeyListener {
    private final GameScene gameScene;
    ProjectLaika game;
    TextSwitch textSwitch;
    TextTimer textTimer;
    public TutorialScene(ProjectLaika game, GameScene gameScene) {
        this.game = game;
        this.gameScene = gameScene;
    }
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupTimers() {
        textTimer = new TextTimer(500);
        addTimer(textTimer);
    }

    @Override
    public void setupEntities() {
        textSwitch = new TextSwitch(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(textSwitch);
        OnbekendePlaneet onbekendePlaneet = new OnbekendePlaneet(new Coordinate2D(getWidth() / 2, getHeight() / 2), 150, game, gameScene, 0);
        addEntity(onbekendePlaneet);

    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.SPACE) && !textTimer.isActive()) {
            textSwitch.nieuweZin();
            textTimer.reset();
            textTimer.resume();
        }
    }

}
