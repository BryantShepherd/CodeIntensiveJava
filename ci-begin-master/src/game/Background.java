package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{
    public Background() {
//        image = SpriteUtils.loadImage("assets/images/background/0.png");
        renderer = new Renderer("assets/images/background/0.png");
        position.set(0, -3100 + Settings.GAME_HEIGHT);
        velocity.set(0, 1);
        anchor.set(0, 0);
    }

    @Override
    public void run() {
        super.run(); //invoke super class method

        if (position.y > 0) {
            position.y = 0;
        }
    }
}
