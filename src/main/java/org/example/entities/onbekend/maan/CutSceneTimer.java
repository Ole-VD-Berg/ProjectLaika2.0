package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.Timer;

public class CutSceneTimer extends Timer {
    int i = 0;
    protected CutSceneTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {
        i++;
    }

    public void setReset() {
        i = 0;
    }

    public int getInterval() {
        return i;
    }
}
