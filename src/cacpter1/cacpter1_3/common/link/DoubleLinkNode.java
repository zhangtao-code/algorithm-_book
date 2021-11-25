package cacpter1.cacpter1_3.common.link;

import cacpter1.cacpter1_3.common.Node;

public class DoubleLinkNode<T> implements LinkedNode<T> {
    protected Node<T>first;
    protected Node<T> last;

    @Override
    public void insert(T t) {
        if(first==null){
            first=last=new Node<T>(t);
            return;
        }
        Node<T>node=new Node<T>(last,t);
        last.next=node;
        last=node;
    }

    @Override
    public void deleteLast() {
        if(first==null){
            return;
        }
        Node<T>pre=last.getPre();
        last.pre=null;
        pre.next=null;
        last=pre;
    }

    @Override
    public void delete(int k) {
        int index=0;
        Node<T>node=first;
        while (index<k){
            if(node==null){
                return;
            }
            node=node.next;
            index++;
        }
        if(node==null){
            return;
        }
        Node<T>pre= node.getPre();
        if(pre==null){
            if(first==last){
                first=last=null;
                return;
            }
            Node<T>next=first.next;
            next.pre=null;
            first.next=null;
            first=next;
            return;
        }
        if(node.next==null){
            pre.next=null;
            node.pre=null;
            last=pre;
            return;
        }
        pre.next=node.next;
        node.pre=null;
        node.next.pre=pre;
        node.next=null;
    }

    @Override
    public boolean find(T t) {
       Node<T>node=first;
       while (node!=null){
            if(node.getT().equals(t)){
                return true;
            }
           node=node.next;
       }
       return false;
    }

    @Override
    public void remove(T t) {
        Node<T>current=first;
        while (current!=null){
            if(current.getT().equals(t)){
                Node<T>pre=current.getPre();
                Node<T>next=current.getNext();
                if(pre==null){
                    if(next==null){
                        first=last=null;
                        return;
                    }else{
                        first=next;
                        next.pre=null;
                        current.next=null;
                        current=next;
                    }
                }else{
                    if(next==null){
                        current.pre=null;
                        pre.next=null;
                        last=pre;
                        return;
                    }else{
                        pre.next=next;
                        next.pre=pre;
                        current.next=null;
                        current.pre=null;
                        current=next;
                    }
                }
            }else{
                current=current.next;
            }
        }
    }



    @Override
    public void removeAfter(int k) {
        Node<T>current=first;
        int index=0;
        while (index<k){
            if(current==null){
                return;
            }
            index++;
            current=current.next;
        }
        if(current==null){
            return;
        }
        Node<T>next=current.getNext();
        if(next==null){
            return;
        }
        current.next=null;
        next.pre=null;
        last=current;
    }

    @Override
    public Node<T> getLast() {
        return last;
    }


    @Override
    public void insertAfter(LinkedNode<T> linkedNode) {
        if(linkedNode.getFirst()==null){
            return;
        }
        if(first==null){
            first=linkedNode.getFirst();
            last=linkedNode.getLast();
        }
        last.next=linkedNode.getFirst();
        linkedNode.getFirst().pre=last;
        last=linkedNode.getLast();
    }

    @Override
    public Node<T> getFirst() {
        return first;
    }

    @Override
    public void reverse() {
        Node<T>current=first;
        Node<T>newLast=null;
        Node<T>newFirst=null;
        while (current!=null){
            Node<T>pre=current.getPre();
            Node<T>next=current.getNext();
            if(newLast==null){
                newLast=current;
                newFirst=current;
                current.next=null;
                current.pre=null;
            }else{
                current.next=pre;
                current.pre=null;
                newFirst=current;
            }
            if(next!=null){
                next.pre=null;
            }
            current=next;
        }
        first=newFirst;
        last=newLast;
    }
}
