package org.example.entities.overlays;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.entities.planeten.Planeet;
import org.example.scenes.GameScene;

public class PlanetenText extends DynamicTextEntity implements UpdateExposer {
    private int score = 0;
    private GameScene gameScene;
    Planeet planeet;
    public PlanetenText(Coordinate2D initialLocation, GameScene gameScene, Planeet planeet){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("Score: 0");
        this.gameScene = gameScene;
        this.planeet = planeet;

    }

    @Override
    public void explicitUpdate(long l) {
        setText("Score: " + (planeet.getGeslicedePlaneten()));
    }
}
