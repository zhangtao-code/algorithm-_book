package cacpter1_3.common;

public interface Bag <T> extends Iterable<T>{
    void add(T t);
    boolean isEmpty();
    int size();
}
