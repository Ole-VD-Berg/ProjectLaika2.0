package org.example.entities.timer;

import com.github.hanyaeger.api.Timer;
import org.example.ProjectLaika;
import org.example.entities.sliceable.planeten.Planeet;

public class Timer2 extends Timer {
    private ProjectLaika game;
    private Planeet planeet;
    private int seconde = 0;
    private int minuut = 2;
    public Timer2(long intervalInMs, ProjectLaika game, Planeet planeet) {
        super(1000);
        this.game = game;
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
            //planeet.resetGeslicedePlaneten();
            game.setActiveScene(2);
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

