package game.player;

import game.*;
import game.screen.GameOverScreen;
import game.screen.ScreenManager;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.Math;


public class Player extends GameObject {
    public int frameCount;
    public int hp;
    public boolean immune;
    public Player() {
        position.set(100, 100);
        //image = SpriteUtils.loadImage("assets/images/players/straight/4.png");
        renderer = new Renderer("assets/images/players/straight");
        hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH - 12, Settings.PLAYER_HEIGHT - 8);
        hp = 3;
        immune = false;
        //frameCount = 0;
    }

    public void takeDamage(int damage) {
        if (immune) {
            return;
        }
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            this.deactivate();
        }
        else {
            immune = true; //immune after getting hit
        }
    }

    int immuneCount = 0;
    private void checkImmune() {
        if(immune) {
            immuneCount++;
            if (immuneCount > 120) {
                immune = false;
                immuneCount = 0;
            }
        }
    }
//    public Player(double _x, double _y) {
//        position = new Vector2D(_x, _y);
//        image = SpriteUtils.loadImage("assets/images/players/straight/4.png");
//        //bullet = new PlayerBullet();
//        //frameCount = 0;
//    }

    public void move() {
        if (KeyEventPress.isLeftPress) {
            position.x-=10; //should use constants/var
        }
        if (KeyEventPress.isUpPress) {
            position.y-=10;
        }
        if (KeyEventPress.isDownPress) {
            position.y+=10;
        }
        if (KeyEventPress.isRightPress) {
            position.x+=10;
        }
    }

    public void limitPosition() {
        position.x = Mathx.clamp(position.x, 0 + 32/2, 384 - 32/2);
        position.y = Mathx.clamp(position.y, 0 + 48/2, Settings.GAME_HEIGHT - 48/2); //don't use number, use variable
    }

    public void fire() {
        if(KeyEventPress.isFirePress == true && frameCount > 20) { //frameCount de kiem soat toc do dan
            // fire a number of bullet, with equal angle between trajectories
            int numBullet = 5;
            double startX = position.x - 10;
            double endX = position.x + 10;
            double stepX = (endX - startX)/(numBullet - 1);
            double startAngle = -120;
            double endAngle = -60;
            double stepAngle = (endAngle - startAngle)/(numBullet - 1);
            for (int i = 0; i < numBullet; i++) {
                PlayerBullet newBullet = new PlayerBullet();
                newBullet.position.set(startX + stepX*i, position.y);
                newBullet.velocity.setAngle(Math.toRadians(startAngle + stepAngle*i));
            }
            frameCount = 0;
        }
    }

    public void bulletRun() {
        frameCount++;
    }
    public void run() { //this is an IMPORTANT function, so limit the code in here to make it easier to understand it.
        //super.run();
        this.move();
        this.limitPosition();
        this.fire();
        this.bulletRun();
        this.checkImmune();
    }

    @Override
    public void render(Graphics g) {
        if (immune) {
            if (immuneCount % 5 == 0) {
                super.render(g);
            }
        }
        else {
            super.render(g);

        }

    }

    @Override
    public void deactivate() {
        super.deactivate();
        ScreenManager.signNewScreen(new GameOverScreen());
    }
}
