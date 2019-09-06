package game;

import tklibs.SpriteUtils;

import java.awt.*;

public class Background extends GameObject{
    public Background() {
        position.set(0, 0);
        image = SpriteUtils.loadImage("assets/images/background/background.png");
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
