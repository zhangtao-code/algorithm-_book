package cacpter1_4;

import cacpter1_3.common.deque.Deque;
import cacpter1_3.common.stack.LinkedStack;
import cacpter1_3.common.stack.Stack;

public class Homework1_4_31 {
    public static void main(String []args){

    }


}
class MyDequeue<T> implements Deque<T>{
    protected Stack<T>left=new LinkedStack<>();
    protected Stack<T>right=new LinkedStack<>();
    protected Stack<T>temp=new LinkedStack<>();

    @Override
    public int size() {
        return left.size()+right.size();
    }

    @Override
    public void pushLeft(T t) {
        left.push(t);
    }

    @Override
    public void pushRight(T t) {
        right.push(t);
    }

    @Override
    public T popLeft() {
        if(!left.isEmpty()){
            return left.pop();
        }
        if (right.isEmpty()){
            return null;
        }
        while (!right.isEmpty()){
            temp.push(right.pop());
        }
        T t=temp.pop();
        while (!temp.isEmpty()){
            right.push(temp.pop());
        }
        return t;
    }

    @Override
    public T popRight() {
        if(!right.isEmpty()){
            return right.pop();
        }
        if (left.isEmpty()){
            return null;
        }
        while (!left.isEmpty()){
            temp.push(left.pop());
        }
        T t=temp.pop();
        while (!temp.isEmpty()){
            left.push(temp.pop());
        }
        return t;
    }
}
