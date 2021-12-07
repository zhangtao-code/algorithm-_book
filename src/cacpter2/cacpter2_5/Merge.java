package cacpter2.cacpter2_5;

public class Merge implements Sort {
    public static void main(String[] args) {//选择排序，时间复杂度N2
        Merge merge = new Merge();
        int[] array = {3, 34, 4, 45, 54, 23, 7787, 45, 5, 3, 45423};
        array = merge.sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    @Override
    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1, new int[array.length]);
        return array;
    }

    public void sort(int[] array, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
        sort(array, low, mid, temp);
        sort(array, mid + 1, high, temp);
        merge(array, low, mid, high, temp);
    }

    public void merge(int array[], int low, int mid, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        if (high - low == 1) {
            if (array[high] < array[low]) {
                swap(array, low, high);
            }
            return;
        }
        if (array[mid] <= array[mid + 1]) {
            return;
        }
        for (int i = low; i <= mid; i++) {
            temp[i] = array[i];
        }
        int index = mid + 1;
        for (int i = high; i > mid; i--) {
            temp[i] = array[index++];
        }
        int k = low;
        int j = high;
        for (int i = low; i <= high; i++) {
            if (temp[j] > temp[k]) {
                array[low++] = temp[k++];
            } else {
                array[low++] = temp[j--];
            }
        }
    }

}
