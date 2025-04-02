package org.example.entities.onbekend.maan;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.example.ProjectLaika;

public class Maan extends DynamicCompositeEntity implements UpdateExposer {
    private String maan = "maan";
    private ProjectLaika game;
    public Maan(Coordinate2D initialLocation, ProjectLaika game) {
        super(initialLocation);
        this.game = game;
    }

    @Override
    public void setupEntities() {
        MaanSprite sprite = new MaanSprite("sprites/onbekend/" + maan + ".png", new Coordinate2D(0, 0), new Size(150, 150), 1, 1, game);
        addEntity(sprite);
    }

    @Override
    public void explicitUpdate(long l) {

    }
}
