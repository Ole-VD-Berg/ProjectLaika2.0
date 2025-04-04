package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.Timer;

public class ZwartGatTimer extends Timer {
    private int interval;
    protected ZwartGatTimer(long intervalInMs, int startInterval) {
        super(intervalInMs);
        this.interval = startInterval;
    }

    @Override
    public void onAnimationUpdate(long l) {
        interval ++;
    }

    public int getAantalInterval(){
        return interval;
    }

    public void resetInterval(){
        interval = 0;
    }
}
