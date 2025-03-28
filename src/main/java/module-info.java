module ProjectLaika20 {
    requires hanyaeger;
    requires java.desktop;

    opens backgrounds;
    opens sprites;
    opens sprites.planeten;
    opens sprites.planeten.overlays;
    exports org.example;


}