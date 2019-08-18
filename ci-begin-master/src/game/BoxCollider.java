package game;

import javax.swing.*;

public class BoxCollider {
    public Vector2D position;
    public double width, height;
    public BoxCollider() {
        this(-1, 1, 1, 1);
    }

    public BoxCollider(double x, double y, double width, double height) {
        position = new Vector2D(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(GameObject object, int width, int height) {
//        position = new Vector2D(object.position.x, object.position.y);
        position = object.position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return position.y;
    }

    public double bottom() {
        return top() + height;
    }

    public double left() {
        return position.x;
    }

    public double right() {
        return left() + width;
    }

    public boolean intersect(BoxCollider other) {
        if (other.right() >= this.left() && other.left() <= this.right() && other.top() <= this.bottom() && other.bottom() >= this.top()) {
            return true;
        }
        return false;
    }
//    public static void main(String[] args) {
//        Rectangle r1 = new Rectangle(0, 0, 3, 3);
//        Rectangle r2 = new Rectangle(1, 1, 3, 3);
//        Rectangle r3 = new Rectangle(4, 4, 3, 3);
//        System.out.println(r1.intersect(r2));
//        System.out.println(r2.intersect(r3));
//        System.out.println(r3.intersect(r1));
//    }
}
