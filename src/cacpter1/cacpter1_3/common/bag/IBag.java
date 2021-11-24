package cacpter1.cacpter1_3.common.bag;

public interface IBag<T>extends Iterable<T> {
    boolean isEmpty();
    int size();
    void enqueue(T t);
    T dequeue();
    T peek();
}
