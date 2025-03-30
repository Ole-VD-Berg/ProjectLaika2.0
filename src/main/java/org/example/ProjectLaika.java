package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameScene;
import org.example.scenes.TitleScene;

import java.awt.*;

public class ProjectLaika extends YaegerGame
{

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    
    public static void main( String[] args ) {
        launch(args);
    }


    @Override
    public void setupGame() {
        setGameTitle("project Laika");
        setSize(new Size(width / 2, height / 2));

    }

    @Override
    public void setupScenes() {
        addScene(0, new GameScene(this));
        addScene(1, new TitleScene(this));

    }

    public double getWidth() {
        return width / 2;
    }

    public double getHeight() {
        return height / 2;
    }
}
