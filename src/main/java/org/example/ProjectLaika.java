package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.*;

import java.awt.*;

public class ProjectLaika extends YaegerGame
{

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double ScreenWidth = screenSize.getWidth();
    double ScreenHeight = screenSize.getHeight();
    private final double width = ScreenWidth / 2;
    private final double height = ScreenHeight / 2;
    public static void main( String[] args ) {
        launch(args);
    }


    @Override
    public void setupGame() {

        setGameTitle("project Laika");
        setSize(new Size(width, height));

    }

    @Override
    public void setupScenes() {


        GameScene gameScene = new GameScene(this);
        addScene(0, new TitleScene(this)); //laad eerst de title scene
        addScene(1, gameScene);
        addScene(2, new EndScene(this, gameScene)); //laad de eind scene
        addScene(3, new OnbekendeScene(this, gameScene)); //laad de onbekende scene
        addScene(4, new TutorialScene(this, gameScene));
         //laad de tutorial scene

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}


