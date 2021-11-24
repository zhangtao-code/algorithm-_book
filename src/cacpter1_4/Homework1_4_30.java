package cacpter1_4;

import cacpter1_3.common.Steque;
import cacpter1_3.common.deque.Deque;
import cacpter1_3.common.stack.LinkedStack;
import cacpter1_3.common.stack.Stack;

public class Homework1_4_30 {
    public static void main(String []args){

    }


}
class MyDeque <T> implements Deque<T> {
    protected Stack<T>stack=new LinkedStack<>();
    protected Steque<T>steque=new Steque<>();
    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void pushLeft(T t) {
        steque.enqueue(t);
    }

    @Override
    public void pushRight(T t) {
        steque.push(t);
    }

    @Override
    public T popLeft() {
        if(steque.getSize()==0){
            return null;
        }else if(steque.getSize()==1){
            return steque.pop();
        }
        while (steque.getSize()!=1){
            stack.push(steque.pop());
        }
        T t =steque.pop();
        while (!stack.isEmpty()){
            steque.push(stack.pop());
        }
        return t;
    }

    @Override
    public T popRight() {
       return steque.pop();
    }
}
