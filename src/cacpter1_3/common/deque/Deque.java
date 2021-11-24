package cacpter1_3.common.deque;

public interface Deque <T>{
    default boolean isEmpty(){
        return size()==0;
    }
    int size();
    void pushLeft(T t);
    void pushRight(T t);
    T popLeft();
    T popRight();

}
