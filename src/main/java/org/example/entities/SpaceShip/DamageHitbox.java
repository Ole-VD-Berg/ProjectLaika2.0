package org.example.entities.SpaceShip;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import org.example.entities.overlays.OverlaySprite;
import org.example.entities.sliceable.vijandig.astroide.Astroide;
import org.example.entities.sliceable.vijandig.schip.Bullet;
import org.example.entities.tools.laser.LaserPunt;

import java.util.List;

public class DamageHitbox extends RectangleEntity implements Collided {
    private int bulletHit = 0;
    OverlaySprite overlaySprite;

    public DamageHitbox(Coordinate2D initialPosition, Size size, OverlaySprite overlaySprite) {
        super(initialPosition, size);
        this.overlaySprite = overlaySprite;
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Bullet bullet) {
                bulletHit++;
                bullet.remove();
                if(bulletHit == 3) {
                    overlaySprite.increaseSpriteFrame();
                    bulletHit = 0;
                }
            }
            if(collider instanceof Astroide astroide) {
                overlaySprite.increaseSpriteFrame();
                astroide.remove();
                playSound();
            }
        }
    }
    private void playSound() {
        var glas = new SoundClip("audio/glas.mp3");
        glas.setVolume(5);
        glas.play();
    }
}
