module ProjectLaika20 {
    requires hanyaeger;
    requires java.desktop;

    opens backgrounds;
    //opens sprites;
    opens backgrounds.overlays;
    opens sprites.titleScene;
    opens sprites.planeten;
    opens sprites.planeten.overlays;
    exports org.example;


}