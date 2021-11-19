package cacpter1_3.common.bag;

import cacpter1_3.common.IteratorArray;

import java.util.Iterator;
import java.util.Random;

public class RandomBag<T> implements IBag<T>{

    protected Object[]array;
    protected int size;
    protected int factor;

    public RandomBag(int factor,int cap) {
        array=new Object[cap];
        this.factor = factor;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T t) {
        if(size>=array.length){
            resize();
        }
        array[size++]=t;
    }

    @Override
    public T dequeue() {
        random();
        T t=(T)array[--size];
        return t;
    }
    protected void random(){
        Random random=new Random();
        for (int i = size-1; i > 1; i--) {
            int index=random.nextInt(i);
            Object temp=array[index];
            array[index]=array[i];
            array[i]=temp;
        }
    }
    @Override
    public T peek() {
       return (T)array[size-1];
    }

    @Override
    public Iterator<T> iterator() {
        if(size<=0){
            return new IteratorArray<>(new Object[0]);
        }
        Object []clone=new Object[size];
        System.arraycopy(array,0,clone,0,size);
        random();
        return new IteratorArray<>(clone);
    }
    protected void resize(){
        int length=array.length*(1+factor);
        if(length==array.length){
            length<<=1;
        }
        Object[]clone=new Object[length];
        System.arraycopy(array,0,clone,0,size);
        array=clone;
        return;
    }
}
