package cacpter1_3.common.stack;

import cacpter1_3.common.IteratorArray;
import cacpter1_3.common.Node;

import java.util.Iterator;

public class LinkedStack <T>implements Stack<T> {
    protected Node<T> last;
    protected int size;
    public LinkedStack(T t) {
        last=new Node<>(t);
    }

    public LinkedStack() {
    }

    public static <T> LinkedStack<T> copy(Stack<T>stack){
        Stack<T>temp=new LinkedStack<>();
        LinkedStack<T>result=new LinkedStack<>();
        Iterator<T> iterator= stack.iterator();
        while (iterator.hasNext()){
            temp.push(iterator.next());
        }
        while (!temp.isEmpty()){
            result.push(temp.pop());
        }
        return result;
    }


    @Override
    public void push(T t) {
        size++;
        if(last==null){
            last=new Node<>(t);
            return;
        }
        Node<T> node=new Node<>(last,t);
        last.next=node;
        last=node;
    }

    @Override
    public T pop() {
        if(last==null){
            return null;
        }
        Node<T>pre=last.pre;
        if(pre!=null){
            pre.next=null;
        }
        last.pre=null;
        T t=last.t;
        last=pre;
        size--;
        return t;
    }
    @Override
    public T peek() {
        if(last==null){
            return null;
        }
        return last.t;
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
        Node current=last;
        for (int i = size; i > 0; i--) {
            array[i-1]=current.getT();
            current=current.pre;
        }
        return new IteratorArray<>(array);
    }

    @Override
    public Stack<T> reverse() {
        Stack<T>temp=new LinkedStack<>();
        Stack<T>reverse=new LinkedStack<>();
        Iterator<T>iterator=iterator();
        while (iterator.hasNext()){
            temp.push(iterator.next());
        }
        while (!temp.isEmpty()){
            reverse.push(temp.pop());
        }
        return reverse;
    }


}
