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
import org.example.entities.sliceable.planeten.Planeet;


public class TimerText2 extends DynamicTextEntity implements UpdateExposer, TimerContainer {
    ProjectLaika game;
    Timer2 timer2;
    Planeet planeet;

    public TimerText2(Coordinate2D initialLocation, ProjectLaika game, ObjectenSpawner objectenSpawner) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.TOP_CENTER);
        setText("00    00");
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        this.game = game;
        this.planeet = planeet;
//      if (objectenSpawner != null){
//          this.planeet = objectenSpawner.getPlaneet();
//      }
    }



    @Override
    public void explicitUpdate(long l) {
        if (timer2 != null) {
            setText(timer2.getTijd());
        }
    }

    @Override
    public void setupTimers() {
        timer2 = new Timer2(1000, game, planeet);
        addTimer(timer2);
    }
}
