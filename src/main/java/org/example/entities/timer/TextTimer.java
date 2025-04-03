package org.example.entities.timer;
import com.github.hanyaeger.api.Timer;
import org.example.entities.Text.ScrollableText.ScrollableText;

public class TextTimer extends Timer {
    private final ScrollableText scrollableText;
    private int seconde = 0;
    private int minuut = 2;
    public TextTimer(long intervalInMs, ScrollableText scrollableText) {
        super(intervalInMs);
        this.scrollableText = scrollableText;

    }

    @Override
    public void onAnimationUpdate(long l) {
            //ScrollableText.nieuweLetter();

    }

}

