package org.example.entities.text.textSwitch;

import com.github.hanyaeger.api.Timer;

public class TextTimer extends Timer {

    public TextTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {
       pause();
    }

}

