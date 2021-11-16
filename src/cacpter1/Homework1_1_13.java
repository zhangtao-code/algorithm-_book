package cacpter1;

import java.util.Random;

public class Homework1_1_13 {
    public static void main(String[] args) {
        int width = new Random().nextInt(10);
        int height = new Random().nextInt(10);
        int[][] array = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int value = new Random().nextInt(100);
                System.out.print(value + "\t");
                array[i][j] = value;
            }
            System.out.println();
        }
        int[][] zhuanzhi = zhuanZhi(array, width, height);
        for (int i = 0; i < zhuanzhi.length; i++) {
            for (int j = 0; j < zhuanzhi[i].length; j++) {
                System.out.print(zhuanzhi[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 交换ij值
     *
     * @param array
     * @param width
     * @param height
     * @return
     */
    public static int[][] zhuanZhi(int[][] array, int width, int height) {
        int[][] result = new int[width][height];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }
}
