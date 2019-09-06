package game.player;

import game.*;
import tklibs.Mathx;

import java.awt.*;


public class Player2 {
    public int frameCount;
    public int hp;
    public boolean immune;
    public static KeyEventPress keyPress;
    public Player2() {
        //frameCount = 0;
    }

    public void takeDamage(int damage) {

    }

    int immuneCount = 0;
    private void checkImmune() {

    }
//    public Player(double _x, double _y) {
//        position = new game.Vector2D(_x, _y);
//        image = SpriteUtils.loadImage("assets/images/players/straight/4.png");
//        //bullet = new PlayerBullet();
//        //frameCount = 0;
//    }

    public void move() {
        if (keyPress.isLeftPress) {
            System.out.println("left press 2");
        }
        if (keyPress.isUpPress) {
            System.out.println("up press 2");
        }
        if (keyPress.isDownPress) {
            System.out.println("down press 2");
        }
        if (keyPress.isRightPress) {
            System.out.println("right press 2");
        }
    }

    public void limitPosition() {

    }

    public void fire() {

    }

    public void bulletRun() {
        frameCount++;
    }
    public void run() { //this is an IMPORTANT function, so limit the code in here to make it easier to understand it.
//        //super.run();
//        this.move();
//        this.limitPosition();
//        this.fire();
//        this.bulletRun();
//        this.checkImmune();
    }

    public void render(Graphics g) {

    }
}
