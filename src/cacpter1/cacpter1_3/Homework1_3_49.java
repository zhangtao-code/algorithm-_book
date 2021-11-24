package cacpter1.cacpter1_3;


import cacpter1.cacpter1_3.common.queue.Queue;
import cacpter1.cacpter1_3.common.stack.LinkedStack;
import cacpter1.cacpter1_3.common.stack.Stack;

import java.util.Iterator;

public class Homework1_3_49 {
    public static void main(String[]args){

    }
}
class MyQueue<T> implements Queue<T> {
    protected Stack<T>first=new LinkedStack<>();
    protected Stack<T>second=new LinkedStack<>();

    @Override
    public void enqueue(T t) {
        first.push(t);
    }

    @Override
    public T dequeue() {
        second=first.reverse();
        T t=second.pop();
        first=second.reverse();
        return  t;
    }

    @Override
    public boolean isEmpty() {
        return first.isEmpty();
    }

    @Override
    public int size() {
        return first.size();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}