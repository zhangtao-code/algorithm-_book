package cacpter1_3.common;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>{
    protected Object[]array;
    protected int factor;
    protected int size;
    protected int write;
    public ArrayQueue(int cap,int factor) {
        this.factor = factor;
        array=new Object[cap];
    }
    public ArrayQueue(int factor) {
        this.factor = factor;
    }

    @Override
    public void enqueue(T t) {

    }

    @Override
    public T dequeue() {
        return null;

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
    protected void resize(){

    }

}
