package cacpter1_3.common.queue;

import cacpter1_3.common.IteratorArray;
import cacpter1_3.common.queue.Queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {
    protected Object[]array;
    protected int factor;
    protected int read;
    protected int write;
    protected int size;
    public ArrayQueue(int cap,int factor) {
        this.factor = factor;
        array=new Object[cap];
    }
    public ArrayQueue(int factor) {
        this.factor = factor;
    }
    public ArrayQueue(ArrayQueue<T>src){
        array=new Object[src.array.length];
        System.arraycopy(src,0,array,0,src.array.length);
        factor=src.factor;
        read=src.read;
        write=src.write;
        size=src.size;
    }
    @Override
    public void enqueue(T t) {
        if(size>=array.length){
            resize();
        }
        size++;
        array[write]=t;
        write=(write+1)%array.length;
    }

    @Override
    public T dequeue() {
        if(size<=0){
            return null;
        }
        T t=(T)array[read];
        array[read]=null;
        read=(read+1)%array.length;
        size--;
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
        Object[]clone=new Object[size];
        int current=size;
        int rIndex=read;
        int index=0;
        while (current>0){
            clone[index++]=array[rIndex];
            rIndex=(rIndex+1)%array.length;
            current--;
        }
        return new IteratorArray<>(clone);
    }
    protected void resize(){
        int length=array.length*(1+factor);
        if(length==size){
            length*=2;
        }
        Object[]clone=new Object[length];
        int current=size;
        int rIndex=read;
        int index=0;
        while (current>0){
            clone[index++]=array[rIndex];
            rIndex=(rIndex+1)%array.length;
            current--;
        }
        array=clone;
        read=0;
        write=size;
    }

}
