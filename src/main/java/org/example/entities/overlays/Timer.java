package org.example.entities.overlays;

import com.github.hanyaeger.api.TimerContainer;

import java.util.List;

public class Timer implements TimerContainer {



    @Override
    public void addTimer(com.github.hanyaeger.api.Timer timer) {
        TimerContainer.super.addTimer(timer);
    }

    @Override
    public void initTimers() {
        TimerContainer.super.initTimers();
    }

    @Override
    public void setupTimers() {

    }

    @Override
    public List<com.github.hanyaeger.api.Timer> getTimers() {
        return List.of();
    }
}
