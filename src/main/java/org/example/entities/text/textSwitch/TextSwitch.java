package org.example.entities.text.textSwitch;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;
import org.example.scenes.TutorialScene;

public class TextSwitch extends DynamicTextEntity implements UpdateExposer {
    TutorialScene tutorialScene;
    private int zin = 0;
    private String[] text = {
            "druk op spatie om naar de volgende zin te gaan.",
            "in deze game heb je één doel: de aarde beschermen.",
            "dit doe je door te kiezen om planeten te vernietigen of niet.",
            "je hebt drie verschillende planeten",
            "bewoonde, onbewoonde en onbekende planeten:",
            "onbewoonde planeten kun je vernietigen.",
            "bewoonde planeten moet je door laten gaan.",
            "onbekende planeten moet je bekijken met de zaklamp.",
            "je maakt een keuze om ze te vernietigen of niet door een kleine puzzel.",
            "in deze puzzel moet je de goede volgorde van manen onthouden en klikken",
            "daarna beslis je of je de planeet moet vernietigen of niet.",
            "astroïden die kunnen je schip vernietigen.",
            "astroïden dus altijd kapot maken!",
            "zwarte gaten moet je wegjagen met de zaklamp, anders verlies je punten",
            "Er is ook een ruimteschip dat kogels op je afvuurt.",
            "Als drie kogels jou geraakt hebben, gaat er een leven af.",
            "je kunt aan de raamschade zien hoeveel levens je verloren hebt.",
            "je snijdt planeten door met je laser",
            "zet de laser aan door ergens te klikken met je linkermuisknop",
            "je kan de zaklamp aanzetten door middel van je rechtermuisknop",
            "je kan ze beide uitzetten door nog een keer te klikken",
            "planeten gaan kapot als je er doorheen snijdt"

    };
    public TextSwitch(Coordinate2D initialLocation, TutorialScene tutorialScene) {
        super(initialLocation);
        setFill(Color.WHITE);
        setFont(new CustomFont("fonts/Minecraft.ttf", 20));
        setText(text[zin]);
        this.tutorialScene = tutorialScene;
    }

    public void nieuweZin() {
        if(zin < text.length -1) {
            zin++;
            setText(text[zin]);
        }
    }

    @Override
    public void explicitUpdate(long l) {
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
    public int getZin() {
        return zin;
    }
}
