package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import org.example.ProjectLaika;
import org.example.scenes.OnbekendeScene;

public class Maan extends DynamicCompositeEntity implements UpdateExposer, MouseExitListener, MouseEnterListener, MouseButtonPressedListener, TimerContainer {
    private MaanSprite sprite;
    private int volg = 0;
    private OnbekendeScene onbekend;
    private int klick = 0;
    private MaanTimer maanTimer;
    private CutSceneTimer cutSceneTimer;
    private int timerAantal = 0;
    private int CutsceneTijd = 0;
    private boolean isGecklicked = false;
    public Maan(Coordinate2D initialLocation, OnbekendeScene onbekend, int volg) {
        super(initialLocation);
        this.volg = volg;
        this.onbekend = onbekend;
    }

    @Override
    public void setupEntities() {
        sprite = new MaanSprite("sprites/onbekend/maanSpriteSheet.png", new Coordinate2D(0, 0), new Size(150, 150), 3, 1);
        addEntity(sprite);
    }

    @Override
    public void explicitUpdate(long l) {
        CutsceneTijd = cutSceneTimer.getInterval();
        if(CutsceneTijd == volg + 1){
            sprite.setCurrentFrameIndex(2);
        } else if (CutsceneTijd > 6) {
            timerAantal = maanTimer.getInterval();
            if(timerAantal == 3 && isGecklicked == true) {
              sprite.setCurrentFrameIndex(0);
              isGecklicked = false;
              cutSceneTimer.pause();
            }
        } else if (CutsceneTijd <= 6) {
            sprite.setCurrentFrameIndex(0);
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(CutsceneTijd > 5) {
            isGecklicked = true;
            onbekend.setMaanKlick();
            sprite.setCurrentFrameIndex(2);
            maanTimer.setReset();
            if (onbekend.getmaanKlick() == volg) {
                onbekend.setGoed();
            } else {
                onbekend.setFaal();
            }
        }
    }

    @Override
    public void onMouseExited() {
        if (CutsceneTijd > 5) {
            sprite.setCurrentFrameIndex(0);
        }
    }

    @Override
    public void onMouseEntered() {
        if (CutsceneTijd > 5) {
            sprite.setCurrentFrameIndex(1);
        }
    }

    @Override
    public void setupTimers() {
        cutSceneTimer = new CutSceneTimer(500);
        addTimer(cutSceneTimer);

        maanTimer = new MaanTimer(100);
        addTimer(maanTimer);
    }
}
