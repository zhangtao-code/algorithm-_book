package cacpter1_3.common;

public interface Stack<T> extends Iterable<T>{
    void push(T t);
    T pop();
    boolean isEmpty();
    T peek();

    int size();
}
