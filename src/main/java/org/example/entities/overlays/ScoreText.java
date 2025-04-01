package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import com.github.hanyaeger.api.entities.impl.CustomFont;
public class ScoreText extends TextEntity implements UpdateExposer {
    private static int score;
    public ScoreText(Coordinate2D initialLocation){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("Score: 0");
    }

//     public static void telBijScoreOp(int scoreErbij){
//       score+= scoreErbij;
       //setText("Score: " + score);
    }


    @Override
    public void explicitUpdate(long l) {
        System.out.println("Score: " + score);
        setText("Score: " + score);
    }
}
