package cacpter1_3;

import cacpter1_3.common.FixCapacityStack;
import cacpter1_3.common.LinkedQueue;
import cacpter1_3.common.Queue;
import cacpter1_3.common.Stack;


public class Homework1_3_15 {
    public static void main(String[]args){

        for (int i = 0; i < 4; i++) {
            Queue<Integer>queue=new LinkedQueue<>();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            System.out.println(find(queue,i+1));
        }
    }
    public static int  find(Queue<Integer>queue,int k){
        Stack<Integer>stack=new FixCapacityStack<>(queue.size()+1);
        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        int value=0;
        while (k>0){
            value= stack.pop();
            k--;
        }
        return value;
    }
}
