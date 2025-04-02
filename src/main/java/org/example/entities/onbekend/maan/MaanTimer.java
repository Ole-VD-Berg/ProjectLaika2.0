package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.Timer;

public class MaanTimer extends Timer {
    private int i = 0;
    protected MaanTimer(long intervalInMs) {
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
