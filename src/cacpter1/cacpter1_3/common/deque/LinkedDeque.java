package cacpter1.cacpter1_3.common.deque;

import cacpter1.cacpter1_3.common.Node;

public class LinkedDeque<T> implements Deque<T> {
    protected Node<T> first;
    protected Node<T>last;
    protected int size;

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pushLeft(T t) {
        size++;
        if(first==null){
            first=last=new Node<T>(t);
            return;
        }
        Node<T>node= new Node<>(t,first);
        first=node;
    }

    @Override
    public void pushRight(T t) {
        size++;
        if(first==null){
            first=last=new Node<T>(t);
            return;
        }
        Node<T>node=new Node<T>(t);
        last.next=node;
        last=node;
    }

    @Override
    public T popLeft() {
        if(size<=0){
            return null;
        }
        size--;
        if(first==last){
            T t=first.getT();
            first=last=null;
            return t;
        }
        Node<T>next=first.getNext();
        T t=first.getT();
        first=next;
        return t;
    }

    @Override
    public T popRight() {
        if(size<=0){
            return null;
        }
        size--;
        if(first==last){
            T t=first.getT();
            first=last=null;
            return t;
        }
        Node<T>current=first;
        while (current.next!=last){
            current=current.next;
        }
        T t =last.getT();
        current.next=null;
        last=current;
        return t;
    }
}
