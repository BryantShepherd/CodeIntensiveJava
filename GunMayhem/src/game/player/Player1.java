package game.player;

import game.*;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player1 extends GameObject{
    public int frameCount;
    public int hp;
    public boolean immune;
    public static KeyEventPress keyPress;
    public Player1() {
        //frameCount = 0;
        position.set(100, 100);
        velocity.set(0, Settings.GRAVITY);
        gravity.set(0, 0.2);
        image = SpriteUtils.loadImage("assets/images/player/adventurer-idle-00-1.3.png");
    }

    public void takeDamage(int damage) {

    }

    int immuneCount = 0;
    private void checkImmune() {

    }
    boolean activateEffect = true;
    public void move() {
        if (keyPress.isLeftPress) {
            System.out.println("left press");
            position.x -= 10;
        }
        if (keyPress.isUpPress) {
            System.out.println("up press");
            if (activateEffect) {
                velocity.y = -10;
                activateEffect = false;
            }


        }
        if (keyPress.isDownPress) {
            System.out.println("down press");

        }
        if (keyPress.isRightPress) {
            System.out.println("right press");
            position.x += 10;
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
        velocity.add(gravity.x, gravity.y);
        position.add(velocity.x, velocity.y);
        if (position.y > 500) {
            position.y = 500;
        }
    }

    public void render(Graphics g) {
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
    }
}
