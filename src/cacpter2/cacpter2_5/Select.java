package cacpter2.cacpter2_5;


public class Select implements Sort {
    public static void main(String[] args) {//选择排序，时间复杂度N2
        Select select = new Select();
        int[] array = {3, 34, 4, 45, 54, 23, 7787, 45, 5, 3, 45423};
        array = select.sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
        return array;
    }
}
