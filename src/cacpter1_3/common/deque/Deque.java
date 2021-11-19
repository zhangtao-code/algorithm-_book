package cacpter1_3.common.deque;

public interface Deque <T>{
    boolean isEmpty();
    int size();
    void pushLeft(T t);
    void pushRight(T t);
    T popLeft();
    T popRight();

}
