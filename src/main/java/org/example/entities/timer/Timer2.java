package org.example.entities.timer;

import com.github.hanyaeger.api.Timer;
import org.example.ProjectLaika;
import org.example.Spawners.ObjectenSpawner;
import org.example.entities.sliceable.planeten.Planeet;
import org.example.scenes.GameScene;

public class Timer2 extends Timer {
    private final GameScene gameScene;
    private final ObjectenSpawner objectenSpawner;
    private ProjectLaika game;
    private Planeet planeet;
    private int seconde = 0;
    private int minuut = 2;
    public Timer2(long intervalInMs, ProjectLaika game, GameScene gameScene, ObjectenSpawner objectenSpawner) {
        super(intervalInMs);
        this.objectenSpawner = objectenSpawner;
        this.game = game;
        this.gameScene = gameScene;
    }

    @Override
    public void onAnimationUpdate(long l) {
        if(minuut >= 0) {
            seconde--;
            if (seconde < 0) { // timer logica
                seconde = 59;
                minuut--;
            }
        }
        else{
            gameScene.gefaalt();
        }
    }

    public String getTijd() {
        if (seconde < 10 && minuut < 10)
            return "0" + minuut + "    0" + seconde;
        else {
            return "0" + minuut + "    " + seconde;
        } // mooi weergeven van de timer
    }
    public int getSeconde() {
        return seconde;
    }
    public int getMinuut() {
        return minuut;
    }
}

