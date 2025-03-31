package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import com.github.hanyaeger.api.entities.impl.CustomFont;
public class ScoreText extends TextEntity {

    public ScoreText(Coordinate2D initialLocation){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("Score: 0");
    }

    public void setScoreText(int score){
        setText("Score: " + score);
    }

}
