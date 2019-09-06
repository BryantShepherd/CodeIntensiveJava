import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Human {
    public static int hourGlassTotal(int[][] arr, int x) {
        return arr[x][0] + arr[x+1][0];
    }
    public static void main(String[] args) {
        double d = 12345.678;
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = i;
            }
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println(hourGlassTotal(arr, 1));
    }
}