package cacpter1.cacpter1_3.common;

import java.util.HashMap;
import java.util.Map;

public class LRU<T> {
    protected Map<T,Node<T>> map=new HashMap<>();
    protected Node<T>first;
    protected Node<T>last;
    protected int size;
    protected int cap;

    public LRU(int cap) {//cap>1
        this.cap = cap;
    }

    public void add(T t){
        if(first==null){
            first=last=new Node<T>(t);
            return;
        }
        Node<T>node=map.get(t);
        if(node==null){
            node=new Node<T>(t,first);
            first.pre=node;
            first=node;
            size++;
            if(size>cap){
              Node<T>pre=  last.getPre();
              last.pre=null;
              pre.next=null;
              last=pre;
            }
            return;
        }
        if(first.getT().equals(t)){
            return;
        }
        if(last.getT().equals(t)){
            Node<T>pre=last.getPre();
            pre.next=null;
            last.pre=null;
            last=pre;
            return;
        }
        Node<T>pre=node.getPre();
        Node<T> next=node.getNext();
        pre.next=next;
        next.pre=pre;
        node.pre=null;
        node.next=first;
        first.pre=node;
        first=node;

    }
}
