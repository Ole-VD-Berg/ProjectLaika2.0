package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

public class TimerText extends TextEntity {

    public TimerText(Coordinate2D initialLocation){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("00    00");

    }

    public void setScoreText(int minute, int second) {
        setText(minute + "  " + second);
    }

}
