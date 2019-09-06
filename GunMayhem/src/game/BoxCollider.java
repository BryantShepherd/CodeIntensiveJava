//package game;
//
//public class BoxCollider {
//    public Vector2D position;
//    public double width, height;
//    public BoxCollider() {
//        this(-1, 1, 1, 1);
//    }
//    public Vector2D anchor;
//
//    public BoxCollider(double x, double y, double width, double height) {
//        position = new Vector2D(x, y);
//        this.width = width;
//        this.height = height;
//        anchor = new Vector2D(0.5, 0.5);
//    }
//
//    public BoxCollider(GameObject object, int width, int height) {
////        position = new game.Vector2D(object.position.x, object.position.y);
//        position = object.position;
//        this.width = width;
//        this.height = height;
//        this.anchor = object.anchor;
//    }
//
//    public double top() {
//        return position.y - anchor.y * height; //render object from the center
//    }
//
//    public double bottom() {
//        return top() + height;
//    }
//
//    public double left() {
//        return position.x - anchor.x * width;
//    }
//
//    public double right() {
//        return left() + width;
//    }
//
//    public boolean intersect(BoxCollider other) {
//        if (other.right() >= this.left() && other.left() <= this.right() && other.top() <= this.bottom() && other.bottom() >= this.top()) {
//            return true;
//        }
//        return false;
//    }
////    public static void main(String[] args) {
////        Rectangle r1 = new Rectangle(0, 0, 3, 3);
////        Rectangle r2 = new Rectangle(1, 1, 3, 3);
////        Rectangle r3 = new Rectangle(4, 4, 3, 3);
////        System.out.println(r1.intersect(r2));
////        System.out.println(r2.intersect(r3));
////        System.out.println(r3.intersect(r1));
////    }
//}
