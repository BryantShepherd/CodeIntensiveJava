package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//we can use an array of GameObject object to manage classes more easily.
public class GameObject {
    //Object management
    public static ArrayList<GameObject> listObjects = new ArrayList<>();

    public static void runAll() {
        for (int i = 0; i < listObjects.size(); i++) {
            if (listObjects.get(i).active) {
                listObjects.get(i).run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < listObjects.size(); i++) {
            if (listObjects.get(i).active) {
                listObjects.get(i).render(g);
            }
        }
    }

    public static Enemy findEnemyIntersect(GameObject source) {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object instanceof Enemy && object.hitBox != null && object.hitBox.intersect(source.hitBox) && object.active) { //check if object is Enemy
                return (Enemy) object; //because GameObject is the parent class of Enemy, so we can convert.
            }
        }
        return null;
    }
    //Generic (Java) = Templates(C++)
    //cls ~ Player.class | Enemy.class | PlayerBullet.class
    public static <E> E findIntersects(Class <E> cls, GameObject source) {
        for (int i = 0; i < listObjects.size(); i++) {
            GameObject object = listObjects.get(i);
            if (object.active && cls.isAssignableFrom(object.getClass()) && object.hitBox != null && object.hitBox.intersect(source.hitBox)) {
                return (E) object;
            }
        }
        return null;
    }

    //Object definition
    public Vector2D position;
    public Renderer renderer;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitBox = null;
    public Vector2D anchor;

    public GameObject() {
        listObjects.add(this);
        System.out.println(listObjects.size());
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
        anchor = new Vector2D(0.5, 0.5);
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, this);
        }
    }
    public void deactivate() {
        active = false;
    }
    public void reset() {
        active = true;
    }
    public void run() {
        position.add(velocity.x, velocity.y);
    }
//    public int getImageHeight() {
//        return image.getHeight();
//    }
//
//    public int getImageWidth() {
//        return image.getWidth();
//    }
}
