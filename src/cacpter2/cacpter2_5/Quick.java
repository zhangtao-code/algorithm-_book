package cacpter2.cacpter2_5;

public class Quick implements Sort {
    public static void main(String[] args) {//选择排序，时间复杂度N2
        Quick quick = new Quick();
        int[] array = {3, 34, 4, 45, 54, 23, 7787, 45, 5, 3, 45423};
        array = quick.sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    @Override
    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    public void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = findMid(array, low, high);
        sort(array, low, mid - 1);
        sort(array, mid + 1, high);
    }

    public int findMid(int[] array, int low, int high) {

        int left = low ;
        int right = high+1;
        while (true) {
            while (array[++left] < array[low]) {
                if (left >= high) {
                    break;
                }
            }
            while (array[--right] > array[low]) {
               // right--;
                if (right <= low) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
            swap(array, left, right);
        }
        swap(array, right, low);
        return left;
    }

}
