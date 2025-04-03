package org.example.entities.text.textSwitch;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;

public class TextSwitch extends DynamicTextEntity {
    int zin = 0;
    private String[] text = {
            "druk op spatie om naar de volgende zin te gaan.",
            "in deze game heb je 1 doel: de aarde beschermen.",
            "dit doe je door te kiezen om planeten te vernietigen of niet.",
            "je hebt 3 verschillende planeten",
            "bewoonde planeten, onbekende planeten en onbewoonde planeten.",
            "bewoonde planeten zijn planeten die je door moet laten gaan.",
            "onbewoonde planeten kan je vernietigen.",
            "onbekende planeten moet je bekijken met de zaklamp.",
            "je maakt een keuze om ze te vernietigen of niet door een kleine puzzel",
            "je sliced planeten met je laser",
            "je zet de laser aan door ergens te klikken met je linkermuisknop",
            "je kan de zaklamp aanzetten door midel van je rechtermuisknop",
            "je kan de ze beide uitzetten door nog een keer te klikken",
            "planeten gaan kapot als je er door heen snijdt"


    };
    public TextSwitch(Coordinate2D initialLocation) {
        super(initialLocation);
        setText(text[zin]);

    }

    public void nieuweZin() {
        if(zin < text.length -1) {
            zin++;
            setText(text[zin]);
        }
    }
}
