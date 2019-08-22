package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    //Single image
    public BufferedImage image;
    //Animation
    public ArrayList<BufferedImage> images;
    public int currentIndex;
    public int delayFrame;
    public boolean isOnce; //co chay 1 lan hay khong?

    public Renderer(String url) {
        this(url, 6, false);
    }

    public Renderer(String url, int delayFrame) {
        this(url, delayFrame, false);
    }

    public Renderer(String url, int delayFrame, boolean isOnce) {
        File file = new File(url);
        if(file.isFile()) {
            image = SpriteUtils.loadImage(url);
        }
        if(file.isDirectory()) {
            images = SpriteUtils.loadImages(url);
            currentIndex = 0;
            this.delayFrame = delayFrame;
            this.isOnce = isOnce;
        }
    }
    int frameCount;
    public void render(Graphics g, GameObject master) {
        if(image != null) {
            drawImage(g, image, master);
        }
        if(images != null && images.size() > 0) {
            BufferedImage currentImage = images.get(currentIndex);
            drawImage(g, currentImage, master);
            frameCount++;
            if (frameCount > delayFrame) {
                currentIndex++;
                if (currentIndex >= images.size()) {
                    currentIndex = 0;
                    if (isOnce) {
                        master.deactivate();
                    }
                }
                frameCount = 0;
            }
        }
    }
    private void drawImage(Graphics g, BufferedImage image, GameObject master) {
        g.drawImage(
                image,
                (int) (master.position.x - master.anchor.x * image.getWidth()),
                (int) (master.position.y - master.anchor.y * image.getHeight()),
                null
        );
        //Developer mode
        //1. Mark position (with red dot)
        g.setColor(Color.RED);
        g.fillOval(
                (int) master.position.x - 1,
                (int) master.position.y - 1,
                3,
                3
        );
        //2. Draw hitBox(if possible)
        if (master.hitBox != null) {
            g.setColor(Color.GREEN);
            g.drawRect(
                    (int) master.hitBox.left(),
                    (int) master.hitBox.top(),
                    (int) master.hitBox.width,
                    (int) master.hitBox.height
            );
        }
    }


}
