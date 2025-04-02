package org.example.entities.Text.ScrollableText;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;

public class ScrollableText extends DynamicTextEntity implements UpdateExposer {
    private String[] text = {
            "Scrollable Text",
            "This is a test of the scrollable text feature.",
            "It should scroll horizontally across the screen."
    };
    public ScrollableText(Coordinate2D initialLocation) {
        super(initialLocation);
        setText("hi");

    }

    @Override
    public void explicitUpdate(long l) {

    }
    public void nieuweLetter(){
        if(text.length > 0) {
            text[1] = text[1].substring(0, text.length -1);
            setText(text[1]);
        }

    }
}
