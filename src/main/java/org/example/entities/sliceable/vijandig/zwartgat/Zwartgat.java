package org.example.entities.sliceable.vijandig.zwartgat;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.ProjectLaika;
import org.example.entities.sliceable.SliceableObject;
import org.example.entities.tools.laser.LaserPunt;
import org.example.entities.tools.zaklamp.ZaklampPunt;
import org.example.scenes.GameScene;

import java.util.List;
import java.util.Random;

public class Zwartgat extends SliceableObject implements UpdateExposer, Collided, TimerContainer {
    Coordinate2D locatie;
    private int direction;
    private int bocht = 0;
    private ZwartGatTimer bochtTimer;
    private ZwartGatTimer startTimer;
    private ZwartGatTimer damageTimer;
    private int randomStop = new Random().nextInt(140,300);
    private int randomDraai = new Random().nextInt(1,2) * 2 - 3;
    private int randomStart = new Random().nextInt(0,150);
    private int resetEenKeer = 0;
    public Zwartgat(Coordinate2D initialLocation, int size, ProjectLaika game, GameScene gameScene, int direction) {
        super(initialLocation, size, game, gameScene, direction);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.locatie = initialLocation;
        this.locatie = getLocationInScene();
        this.direction = direction;
        setMotion(SPEED, direction);



    }

    @Override
    public void explicitUpdate(long l) {
        super.explicitUpdate(l);
        if(startTimer.getAantalInterval() > randomStart) {
            if (bocht < randomStop && bocht > (randomStop * -1) ){
                if (resetEenKeer == 0) {
                    bochtTimer.resetInterval();
                    resetEenKeer++;
                }
                bocht = bochtTimer.getAantalInterval();
                bocht *= randomDraai;
                System.out.println(bocht);
            }
            setMotion(SPEED, this.direction + bocht);
        }
    }


    @Override
    protected void setupEntities() {
        super.setupEntities();
        ZwartgatSprite zwartgatSprite = new ZwartgatSprite("sprites/vijandig/zwartgat.png", new Coordinate2D(intitialLocation), new Size(size, size));
        addEntity(zwartgatSprite);


    }
    public Coordinate2D getPlaneetLocatie() {
        return locatie;
    }


    @Override
    protected void doSlicingActie() {
        remove();
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof ZaklampPunt) {
                ZaklampPunt lampPunt = (ZaklampPunt) collider;
                double lampX = lampPunt.getMouseCoordinates().getX();
                double lampY = lampPunt.getMouseCoordinates().getY();
                double distance = berekenAfstand(lampX, lampY);
                if(distance < 25) {
                    remove();
                }
            }
            if (collider instanceof LaserPunt) {
                hitBox.remove();
                LaserPunt laserPunt = (LaserPunt) collider;
                double laserX = laserPunt.getMouseCoordinates().getX();
                double laserY = laserPunt.getMouseCoordinates().getY();
                double distance = berekenAfstand(laserX, laserY);
                if(distance < 25 && damageTimer.getAantalInterval() >= 1) {
                    gameScene.doeScoreErbij(-1);
                    damageTimer.resetInterval();
                }
            }
        }
    }

    public double berekenAfstand(double x, double y) {
        double hitboxX = objectLocation.getX();
        double hitboxY = objectLocation.getY();
        return Math.sqrt(Math.pow(x - hitboxX, 2) + Math.pow(y - hitboxY, 2));
    }

    @Override
    public void setupTimers() {
        bochtTimer = new ZwartGatTimer(5, 0);
        addTimer(bochtTimer);
        startTimer = new ZwartGatTimer(10, 0);
        addTimer(startTimer);
        damageTimer = new ZwartGatTimer(500, 1);
        addTimer(damageTimer);
    }
}



