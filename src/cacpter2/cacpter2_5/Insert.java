package cacpter2.cacpter2_5;

public class Insert implements Sort {
    public static void main(String[] args) {//选择排序，时间复杂度N2
        Insert insert = new Insert();
        int[] array = {3, 34, 4, 45, 54, 23, 7787, 45, 5, 3, 45423};
        array = insert.sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
        return array;
    }
}
