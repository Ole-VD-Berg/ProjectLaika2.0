module ProjectLaika20 {
    requires hanyaeger;
    requires java.desktop;

    opens backgrounds;
    //opens sprites;
    opens backgrounds.overlays;
    opens fonts;
    opens sprites.titleScene;
    opens sprites.planeten;
    opens sprites.planeten.overlays;
    opens sprites.vijandig;
    exports org.example;



}