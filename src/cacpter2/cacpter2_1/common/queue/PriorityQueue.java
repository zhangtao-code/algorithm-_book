package cacpter2.cacpter2_1.common.queue;

public interface PriorityQueue<T extends Comparable<T>> {
    void insert(T t);
    T max();
    T delMax();
    boolean isEmpty();
    int size();
}
