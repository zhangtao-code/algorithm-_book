package cacpter1_3.common.queue;

import cacpter1_3.common.stack.Stack;

import java.util.Iterator;

public interface Queue<T> extends Iterable<T>{
    void enqueue(T t);
    T dequeue();
    boolean isEmpty();
    int size();
    default void catenation(Stack<T> stack) {
        Iterator<T> iterator=iterator();
        while (iterator.hasNext()){
            enqueue(iterator.next());
        }
    }
}
