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
            g.drawImage(
                    image,
                    (int) master.position.x,
                    (int) master.position.y,
                    null
            );
        }
        if(images != null && images.size() > 0) {
            BufferedImage currentImage = images.get(currentIndex);
            g.drawImage(
                    currentImage,
                    (int) master.position.x,
                    (int) master.position.y,
                    null
            );
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
}
