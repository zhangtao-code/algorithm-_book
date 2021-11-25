package cacpter1.cacpter1_3.common.link;

import cacpter1.cacpter1_3.common.Node;

public class SingleLinkedQueue<T> implements LinkedNode<T>{
    protected Node<T> first;
    protected Node<T> last;

    @Override
    public void insert(T t) {
        if(first==null){
            first=last=new Node<T>(t);
            return;
        }
        Node<T>node=new Node<T>(t);
        last.next=node;
    }

    @Override
    public void deleteLast() {
        if(first==null){
            return;
        }
        if(first.next==null){
            first=null;
            last=null;
            return;
        }
        Node<T>node=first;
        while (node.next!=last){
            node=node.next;
        }
        node.next=null;
        last=node;
    }

    @Override
    public void delete(int k) {
        if(first==null||k<0){
            return;
        }
        if(k==0){
            if(first==last){
                first=null;
                last=null;
                return;
            }
            first=first.next;
            return;
        }

        Node pre=first;
        Node node=first.next;
        int index=1;
        while (index<k){
            pre=node;
            node=node.next;
            if(node==null){
                return;
            }
            index++;
        }
        if(node.next==null){
            pre.next=null;
            last=pre;
            return;
        }
        pre.next=node.next;
    }

    @Override
    public boolean find(T t) {
        Node<T> current=first;
        while (current!=null){
            if(current.getT().equals(t)){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public void remove(T t) {
        Node<T> current=first;
        Node<T>pre=null;
        while (current!=null){
            if(current.getT().equals(t)){
                if(pre==null){
                    first=current.next;
                }
                current=current.next;
            }else{
                pre=current;
                current=current.next;
            }
        }
        last=pre;
    }


    @Override
    public void removeAfter(int k) {
        if(k<0){
            return;
        }
        Node<T>pre=null;
        Node<T>current=first;
        int index=0;
        while (index<=k){
            if(current==null){
                return;
            }
            pre=current;
            current=current.next;
            index++;
        }
        if(pre==null){
            first=null;
            last=null;
            return;
        }
        pre.next=null;
        last=pre;
    }

    @Override
    public Node<T> getFirst() {
        return first;
    }

    @Override
    public Node<T> getLast() {
        return last;
    }

    @Override
    public void insertAfter(LinkedNode<T> linkedNode) {
        if(first==null){
           first=linkedNode.getFirst();
           last= linkedNode.getLast();
        }else{
            last.next=linkedNode.getFirst();
        }
    }

    @Override
    public void reverse() {
       Node<T>current=first;
       Node<T>newFirst=null;
       Node<T>newLast=null;
       while (current!=null){
           Node<T>next=current.getNext();
           newFirst=current;
           if(newLast==null){
               newLast=current;
               current.next=null;
           }else{
               current.next=newFirst;
           }
          current=next;
       }
       first=newFirst;
       last=newLast;
    }
}
