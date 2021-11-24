package cacpter1.cacpter1_4;

import cacpter1.cacpter1_3.common.queue.LinkedQueue;
import cacpter1.cacpter1_3.common.queue.Queue;
import cacpter1.cacpter1_3.common.stack.Stack;

import java.util.Iterator;


public class Homework1_4_28 {
    public static void main(String []args){
        Stack<Integer>stack=new Queue2Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }


}
class Queue2Stack<T> implements Stack<T> {
    protected Queue<T> queue=new LinkedQueue<>();
    @Override
    public void push(T t) {
        queue.enqueue(t);
        if(queue.size()==1){
            return;
        }
        for (int i = 0; i < queue.size()-1; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

    @Override
    public T pop() {
        return queue.dequeue();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<T> iterator() {
       return null;
    }
}
