import java.util.Scanner;

public class HelloWorld
{
    public static void main(String[] input)
    {
        String s = "        He is a very very good boy, isn't he?  ";
        s = s.trim();
        //String splitStr = "[ !,?.\\_'@]+";
        String splitStr = "[]/,.? @'$#%]";
        String[] arrStr = s.split(splitStr);
        for (String a : arrStr) {
            System.out.println(a);
        }

    }
}