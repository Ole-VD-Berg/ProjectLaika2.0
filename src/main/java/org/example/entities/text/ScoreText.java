package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import org.example.scenes.GameScene;

public class ScoreText extends DynamicTextEntity implements UpdateExposer {
    private int score = 0;
    private GameScene gameScene;
    public ScoreText(Coordinate2D initialLocation, GameScene gameScene){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 20));
        setFill(Color.WHITE);
        this.gameScene = gameScene;
        setText("score: " + gameScene.getScore());
        setViewOrder(10);

    }

    @Override
    public void explicitUpdate(long l) {
        this.score = gameScene.getScore();
        setText("Score: " + score);
    }
}
