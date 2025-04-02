package org.example.entities.Text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.Spawners.ObjectenSpawner;
import org.example.scenes.GameScene;

public class PlanetenText extends DynamicTextEntity implements UpdateExposer {
    private int score = 0;
    private GameScene gameScene;
    ObjectenSpawner objectenSpawner;
    public PlanetenText(Coordinate2D initialLocation, GameScene gameScene, ObjectenSpawner objectenSpawner){
        super(initialLocation);
        setFont(new CustomFont("fonts/Minecraft.ttf", 10));
        setFill(Color.WHITE);
        setText("plane: 0");
        this.gameScene = gameScene;
        this.objectenSpawner = objectenSpawner;
        setViewOrder(10);

    }

    @Override
    public void explicitUpdate(long l) {
        if (objectenSpawner != null) {
//            Planeet planeet = objectenSpawner.getPlaneet();
//            setText("planeten: " + (planeet.getGeslicedePlaneten()));
        }
    }
}
