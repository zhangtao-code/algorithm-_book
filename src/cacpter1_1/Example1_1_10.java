package cacpter1_1;

public class Example1_1_10 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            System.out.println(rank(array[i], array) == i);
        }
    }

    /**
     * 数组必须是有序的
     *
     * @param key
     * @param array
     * @return
     */
    public static int rank(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;//右移法更快
            if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
