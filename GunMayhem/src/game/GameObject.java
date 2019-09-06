package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //Object Management
    public static ArrayList<GameObject> listObjects = new ArrayList<>();

    public static void runAll() {
        for (int i = 0; i < listObjects.size(); i++) {
            if (listObjects.get(i).active) {
                listObjects.get(i).run();
            }
        }
    }

    //Object Definition
    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;
    public Vector2D gravity;
    public boolean active;
    public BufferedImage image;
    //public Vector2D anchor;

    public GameObject() {
        position = new Vector2D();
        velocity = new Vector2D();
        gravity = new Vector2D();
        active = true;
        listObjects.add(this);
        System.out.println(listObjects.size());
    }

    public void render(Graphics g) {
        g.drawImage(
                image,
                (int) position.x,
                (int) position.y,
                null
        );
    }

    public void deactivate() {
        active = false;
    }

    public void reset() {
        active = true;
    }

    public void run() {

    }
}