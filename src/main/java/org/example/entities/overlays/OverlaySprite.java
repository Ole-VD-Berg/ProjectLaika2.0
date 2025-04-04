package org.example.entities.overlays;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import org.example.scenes.GameScene;


public class OverlaySprite extends DynamicSpriteEntity implements UpdateExposer {
    private static int damage = 0;
    public OverlaySprite(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
        setCurrentFrameIndex(0);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setViewOrder(11);
    }
    public void increaseSpriteFrame() {
        damage ++;
    }

    public int getSpriteframes(){
        return damage;
    }

    public void setDamage(int aantalDamage){
        damage = aantalDamage;
    }

    @Override
    public void explicitUpdate(long l) {
        setCurrentFrameIndex(damage);
    }
}
