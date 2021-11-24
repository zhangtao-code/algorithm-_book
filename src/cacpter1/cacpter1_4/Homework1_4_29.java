package cacpter1.cacpter1_4;

import cacpter1.cacpter1_3.common.stack.LinkedStack;
import cacpter1.cacpter1_3.common.stack.Stack;

public class Homework1_4_29 {
    public static void main(String []args){

    }


}
class Steque<T>{
    protected Stack<T>main;
    protected Stack<T>assist;

    public Steque() {
        main=new LinkedStack<>();
        assist=new LinkedStack<>();
    }
    public void push(T t){
        main.push(t);
    }
    public T pop(){
        return main.pop();
    }
    public void enqueue(T t){
        if(main.isEmpty()){
            main.push(t);
            return;
        }
        while (!main.isEmpty()){
           assist.push(main.pop());
        }
        assist.push(t);
        while (!assist.isEmpty()){
            main.push(assist.pop());
        }
    }
}
