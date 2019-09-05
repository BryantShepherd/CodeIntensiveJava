package Test;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class myClass = Class.forName("Test.Test");
        Object obj = myClass.newInstance();
        System.out.println("Class of obj:" + obj.getClass());
    }
}
