package cacpter1_3.common.stack;

import java.util.Iterator;

public interface Stack<T> extends Iterable<T>{
    void push(T t);
    T pop();
    default boolean isEmpty(){
        return size()==0;
    }
   default T peek(){
       T t=pop();
       if(t!=null){
           push(t);
       }
       return t;
   }
    default void catenation(Stack<T> stack) {
        Stack<T>reverse=reverse();
        while (!reverse.isEmpty()){
            push(reverse.pop());
        }
    }
    int size();
   default Stack<T>reverse(){
       Stack<T>temp=new FixCapacityStack<>(20);
       Stack<T>reverse=new FixCapacityStack<>(20);
       Iterator<T> iterator=iterator();
       while (iterator.hasNext()){
           temp.push(iterator.next());
       }
       while (!temp.isEmpty()){
           reverse.push(temp.pop());
       }
       return reverse;
   }
}
