package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.scenes.GameScene;

public class PlanetenText extends DynamicTextEntity implements UpdateExposer {
    private int score = 0;
    private GameScene gameScene;

    public PlanetenText(Coordinate2D initialLocation, GameScene gameScene){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("0");
        this.gameScene = gameScene;


        setViewOrder(10);

    }

    @Override
    public void explicitUpdate(long l) {

        Planeet planeet = gameScene.getPlaneet();
        if(planeet != null){
            setText("" + planeet.getGeslicedePlaneten());
        }


    }
}
