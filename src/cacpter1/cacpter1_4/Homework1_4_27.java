package cacpter1.cacpter1_4;

import cacpter1.cacpter1_3.common.queue.Queue;
import cacpter1.cacpter1_3.common.stack.LinkedStack;
import cacpter1.cacpter1_3.common.stack.Stack;

import java.util.Iterator;

public class Homework1_4_27 {
    public static void main(String []args){
        DoubleStack2Queue<Integer> queue=new DoubleStack2Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(7);
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }


}
class DoubleStack2Queue<T>implements Queue<T> {
    protected Stack<T>left;
    protected Stack<T>right;

    public DoubleStack2Queue() {
        left= new LinkedStack<>();
        right= new LinkedStack<>();
    }

    @Override
    public void enqueue(T t) {
        left.push(t);
    }

    @Override
    public T dequeue() {
        if(left.isEmpty()){
            return null;
        }
        while (!left.isEmpty()){
            right.push(left.pop());
        }
        T t=right.pop();
        while (!right.isEmpty()){
            left.push(right.pop());
        }
        return t;
    }

    @Override
    public boolean isEmpty() {
      return size()==0;
    }

    @Override
    public int size() {
        return left.size();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
