package cacpter2.cacpter2_5;

public interface Sort {
    default void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    int[] sort(int array[]);
}
