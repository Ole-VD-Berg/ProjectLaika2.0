package org.example.entities.overlays;

import com.github.hanyaeger.api.TimerContainer;

import java.util.List;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.UpdateExposer;

public class TestTimer extends Timer{
    private int i = 0;
    public TestTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {

        System.out.println(i);
        i++;
    }
}
