package org.example.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.ProjectLaika;

public class QuitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private ProjectLaika game;
    public QuitButton(Coordinate2D initialLocation , ProjectLaika game) {
        super(initialLocation, "quit");
        this.game = game;
        setFill(Color.BLUE);
        setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.quit();
    }

    @Override
    public void onMouseEntered() {
       // setSprite("buttons/quitButtonHover.png");
    }

    @Override
    public void onMouseExited() {
        //setSprite("buttons/quitButton.png");
    }
}
