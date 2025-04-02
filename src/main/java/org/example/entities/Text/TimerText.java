package org.example.entities.Text;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.entities.overlays.TestTimer;

public class TimerText extends DynamicTextEntity implements UpdateExposer, TimerContainer {
    TestTimer timer;

    private int minute = 0;
    boolean help = true;
    public TimerText(Coordinate2D initialLocation){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void setTimerText(int minute, int second) {
        setText(minute + "  " + second);
    }

    @Override
    public void setupTimers() {
        timer = new TestTimer(1000);
        addTimer(timer);
    }

    @Override
    public void explicitUpdate(long l) {
        if(timer.getSeconde() % 60 == 20){help = false;}
        if(timer.getSeconde() % 60 == 0 && !help) {
            minute++;
            help = true;
        }
        if(timer != null) {
            setText(minute + "    " + timer.getSeconde() % 60);
        }
    }
}
