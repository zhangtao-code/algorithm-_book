package cacpter2.cacpter2_1.common.queue;

public class Heap {
    public static void main(String[] args) {
        int a[] = {1, 2, 342, 3412, 4, 32, 423, 42, 34, 234};
        sort(a);
        for (int i : a) {
            System.out.print(i + "\t");
        }
    }

    public static void sort(int array[]) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            max(array, i, array.length);
        }
        for (int length = array.length - 1; length > 0; length--) {
            swap(array, 0, length);
            max(array, 0, length);
        }
    }

    public static void max(int array[], int index, int max) {
        int temp = array[index];
        for (int j = index * 2 + 1; j < max; j = j * 2 + 1) {
            if (j + 1 < max && array[j + 1] > array[j]) {
                j++;
            }
            if (array[j] > temp) {
                array[index] = array[j];
                index = j;
            }
        }
        array[index] = temp;
    }

    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
