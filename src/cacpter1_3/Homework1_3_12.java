package cacpter1_3;

import cacpter1_3.common.FixCapacityStack;
import cacpter1_3.common.LinkedStack;
import cacpter1_3.common.Stack;


public class Homework1_3_12 {
    public static void main(String[]args){
        Stack<Integer>stack=new FixCapacityStack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack=clone(stack);
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"\t");
        }
    }
    public static Stack<Integer>  clone(Stack<Integer> express){
        LinkedStack<Integer>stack=LinkedStack.copy(express);
        return stack;
    }
}
