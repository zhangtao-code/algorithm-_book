package cacpter1;

import java.util.Random;

public class Homework1_1_15 {
    public static void main(String[] args) {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        array = histogram(array, 10);
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+":\t"+array[i]);
        }
    }

    public static int[] histogram(int[] array, int m) {
        int[] result = new int[m];
        for (int value : array) {
            if (value >= m || value < 0) {
                continue;
            }
            result[value] = result[value] + 1;
        }
        return result;
    }
}
