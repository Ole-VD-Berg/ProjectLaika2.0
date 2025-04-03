package org.example.entities.timer;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.scenes.GameScene;


public class TimerText2 extends DynamicTextEntity implements UpdateExposer, TimerContainer {
    private final ObjectenSpawner objectenSpawner;
    ProjectLaika game;
    Timer2 timer2;
    GameScene gameScene;

    public TimerText2(Coordinate2D initialLocation, ProjectLaika game, GameScene gameScene, ObjectenSpawner objectenSpawner) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setText("00    00");
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        this.game = game;
        this.gameScene = gameScene;
        this.objectenSpawner = objectenSpawner;
        setViewOrder(10);
    }



    @Override
    public void explicitUpdate(long l) {
        if (timer2 != null) {
            setText(timer2.getTijd());

            if (timer2.getSeconde() == 30 || timer2.getSeconde() == 59) {
                if (gameScene.getObjectenSpawner() != null) {
                    gameScene.getObjectenSpawner().veranderKant();
                }
            }
        }
    }

    @Override
    public void setupTimers() {
        timer2 = new Timer2(1000, game, gameScene, objectenSpawner);
        addTimer(timer2);
    }

}
