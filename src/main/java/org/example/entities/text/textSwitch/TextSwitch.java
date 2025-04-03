package org.example.entities.text.textSwitch;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import javafx.scene.paint.Color;

public class TextSwitch extends DynamicTextEntity implements UpdateExposer {

    private int zin = 0;
    private String[] text = {
            "druk op spatie om naar de volgende zin te gaan.",
            "in deze game heb je 1 doel: de aarde beschermen.",
            "dit doe je door te kiezen om planeten te vernietigen of niet.",
            "je hebt 3 verschillende planeten",
            "bewoonde, onbewoonde en onbekende planeten.",
            "onbewoonde planeten kan je vernietigen.",
            "bewoonde planeten zijn planeten die je door moet laten gaan.",
            "onbekende planeten moet je bekijken met de zaklamp.",
            "je maakt een keuze om ze te vernietigen of niet door een kleine puzzel",
            "je sliced planeten met je laser",
            "je zet de laser aan door ergens te klikken met je linkermuisknop",
            "je kan de zaklamp aanzetten door midel van je rechtermuisknop",
            "je kan ze beide uitzetten door nog een keer te klikken",
            "planeten gaan kapot als je er door heen snijdt"

    };
    public TextSwitch(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.WHITE);
        setFont(new CustomFont("fonts/Minecraft.ttf", 20));
        setText(text[zin]);
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
