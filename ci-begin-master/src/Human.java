import java.lang.reflect.Array;
import java.util.ArrayList;

public class Human {
    public static void main(String[] args) {
        ArrayList<String> arrString = new ArrayList<>();
        System.out.println("Array size: " + arrString.size());
        arrString.add("h");
        arrString.add("e");
        arrString.add("l");
        System.out.println(arrString.size());
        System.out.println(arrString);
        for (int i = 0; i < arrString.size(); i++) {
            String arrItem = arrString.get(i);
            System.out.println(arrItem);
        }
    }
}