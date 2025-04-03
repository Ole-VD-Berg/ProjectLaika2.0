package org.example.entities.SpaceShip;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import javafx.scene.paint.Color;
import org.example.entities.overlays.OverlaySprite;
import org.example.entities.sliceable.vijandig.astroide.Astroide;
import org.example.entities.sliceable.vijandig.schip.Bullet;
import org.example.scenes.GameScene;


import java.util.List;

public class DamageHitbox extends DynamicRectangleEntity implements Collided, UpdateExposer {
    private final GameScene gameScene;
    private int bulletHit = 0;
    OverlaySprite overlaySprite;

    public DamageHitbox(Coordinate2D initialPosition, Size size, OverlaySprite overlaySprite, GameScene gameScene) {
        super(initialPosition, size);
        this.overlaySprite = overlaySprite;
        this.gameScene = gameScene;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
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
                    playSound();
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

    @Override
    public void explicitUpdate(long l) {
        if(gameScene.getObjectenSpawner().getSchip() == null){
            bulletHit = 0;
        }
    }
}
