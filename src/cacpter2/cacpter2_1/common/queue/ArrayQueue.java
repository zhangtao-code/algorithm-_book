package cacpter2.cacpter2_1.common.queue;

public class ArrayQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    protected int size;
    protected Object[] array;

    public ArrayQueue(int cap) {
        array = new Object[cap];
    }

    @Override
    public void insert(T t) {
        array[++size] = t;
        swim(size);
    }

    @Override
    public T max() {
        return (T) array[1];
    }

    @Override
    public T delMax() {
        T t = (T) array[1];
        array[1] = array[size];
        array[size--] = null;
        sink(1);
        return t;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    protected boolean less(int i, int j) {
        return ((T) array[i]).compareTo((T) array[j]) < 0;
    }

    protected void exch(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected void swim(int index) {
        while (index >= 2) {
            int next = index / 2;
            if (less(next, index)) {
                exch(next, index);
                index = next;
            } else {
                break;
            }
        }
    }

    protected void sink(int index) {
        while (2 * index <= size) {
            int j = 2 * index;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(index, j)) {
                exch(index, j);
            }
            index = j;
        }
    }

}
