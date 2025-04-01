package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import org.example.scenes.GameScene;

public class ScoreText extends DynamicTextEntity implements UpdateExposer {
    private int score = 0;
    private GameScene gameScene;
    public ScoreText(Coordinate2D initialLocation, GameScene gameScene){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("Score: 0");
        this.gameScene = gameScene;
    }

    @Override
    public void explicitUpdate(long l) {
        this.score = gameScene.getScore();
        setText("Score: " + score);
    }
}
