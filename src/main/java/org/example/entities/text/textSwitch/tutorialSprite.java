package org.example.entities.text.textSwitch;

<<<<<<< Updated upstream
import com.github.hanyaeger.api.AnchorPoint;
=======
>>>>>>> Stashed changes
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


<<<<<<< Updated upstream
public class TutorialSprite extends DynamicSpriteEntity {

    public TutorialSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

=======
public class tutorialSprite extends DynamicSpriteEntity {

    protected tutorialSprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }
>>>>>>> Stashed changes
    public void nieuweFrame() {
        setCurrentFrameIndex(getCurrentFrameIndex() + 1);
    }
}
