package cacpter1_3.common;

public class Steque<T> {
    protected Node<T>first;
    protected Node<T>last;
    public void enqueue(T t){
       if(first==null){
           first=last=new Node<T>(t);
           return;
       }
       Node<T>node=new Node<T>(t,first);
       first.pre=node;
       first=node;

    }
    public void push(T t){
        if(first==null){
            first=new Node<T>(t);
            last=first;
            return;
        }
        Node<T>node=new Node<T>(last,t);
        last.next=node;
        last=node;
    }
    public T pop(){
        if(first==last){
            T t=first.getT();
            first=last=null;
            return t;
        }
        Node<T>pre=last.getPre();
        T t=last.getT();
        last.pre=null;
        pre.next=null;
        last=pre;
        return t;
    }
}
