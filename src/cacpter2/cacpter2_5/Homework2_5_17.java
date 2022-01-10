package cacpter2.cacpter2_5;

import java.util.HashMap;
import java.util.Map;

public class Homework2_5_17 {
    public static void main(String[] args) {
        int a[] = {11, 2, 3, 4};
        int b[] = {4, 3, 2, 11};
        distance(a, b);
    }

    public int juli(int[] array1, int[] array2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map1.put(array1[i], i);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < array2.length; i++) {
            map2.put(array2[i], i);
        }
        return 0;
    }

    public static long distance(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Array dimensions disagree");
        }
        int n = a.length;

        int[] ainv = new int[n];
        for (int i = 0; i < n; i++)
            ainv[a[i]] = i;

        Integer[] bnew = new Integer[n];
        for (int i = 0; i < n; i++)
            bnew[i] = ainv[b[i]];

        return 0;
    }

}
