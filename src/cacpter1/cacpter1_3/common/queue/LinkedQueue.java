package cacpter1.cacpter1_3.common.queue;

import cacpter1.cacpter1_3.common.IteratorArray;
import cacpter1.cacpter1_3.common.Node;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
    protected Node<T> first;
    protected Node<T>last;
    protected int size;

    @Override
    public void enqueue(T t) {
        size++;
        if(first==null){
            first=new Node<T>(t);
            last=first;
            return;
        }
        Node<T> current=new Node<T>(last,t);
        last.next=current;
        last=current;
    }

    @Override
    public T dequeue() {
        if(first==null){
            return null;
        }
        size--;
        T t=first.t;
        Node<T> next=first.next;
        if(next!=null){
            next.pre=null;
        }else{
            last=null;
        }
        first=next;
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
        if(size==0){
            return new IteratorArray<>(new Object[0]);
        }
        Object []array=new Object[size];
        Node<T> node=first;
        for (int i = 0; i < size; i++) {
            array[i]= node.t;
            node=node.next;
        }
        return new IteratorArray<>(array);
    }
}
