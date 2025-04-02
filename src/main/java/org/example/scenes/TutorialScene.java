package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.ProjectLaika;
import org.example.entities.Text.ScrollableText.ScrollableText;
import org.example.entities.timer.TextTimer;

public class TutorialScene extends DynamicScene implements TimerContainer {
    ProjectLaika game;
    ScrollableText scrollableText;
    public TutorialScene(ProjectLaika game) {
        this.game = game;
    }
    public void setupScene() {
        setBackgroundImage("backgrounds/backgroundUpscale.png");
    }

    @Override
    public void setupEntities() {
        scrollableText = new ScrollableText(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        addEntity(scrollableText);


    }

    @Override
    public void setupTimers() {
        TextTimer textTimer = new TextTimer(1000, scrollableText);
        addTimer(textTimer);
    }
}
