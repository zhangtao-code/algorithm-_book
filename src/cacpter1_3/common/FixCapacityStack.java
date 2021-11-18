package cacpter1_3.common;

import java.util.Iterator;

public class FixCapacityStack<T> implements Stack<T>{
    private int size;
    private Object[]array;
    private int factor=1;
    public FixCapacityStack(int cap) {
        if(cap<0){
            throw new IllegalArgumentException("长度至少为0");
        }
        array=new Object[cap];
    }
    public FixCapacityStack(int cap, int factor) {
        this(cap);
        if(factor<=0){
            throw new IllegalArgumentException("扩容因子必须大于0");
        }
        this.factor=factor;
    }

    @Override
    public void push(T t) {
        if(size>=array.length-1){
            resize();
        }
        array[size++]=t;
    }

    protected void resize(){
        System.out.println("开始扩容");
        int length=array.length*(1+factor);
        if(length==size){
            length*=2;
        }
        Object []dest=new Object[length];
        System.arraycopy(array,0,dest,0,array.length);
        array=dest;
    }

    @Override
    public T pop() {
        if(size==0){
            return null;
        }
        T t= (T) array[size-1];
        array[--size]=null;
        return t;
    }
    @Override
    public T peek() {
        if(size==0){
            return null;
        }
        T t= (T) array[size-1];
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        Object []clone=new Object[size];
        System.arraycopy(array,0,clone,0,size);
       return new IteratorArray<>(clone);
    }
}
