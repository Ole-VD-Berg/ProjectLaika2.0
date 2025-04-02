package org.example.entities.sliceable.vijandig.schip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class SchipGun extends DynamicCompositeEntity implements UpdateExposer {
    Schip schip;

    protected SchipGun(Coordinate2D initialLocation, Schip schip) {
        super(initialLocation);
        this.schip = schip;
    }

    @Override
    protected void setupEntities() {

    }

    @Override
    public void explicitUpdate(long l) {
      //  setAnchorlocation(Schip.getLocation());
    }
}
