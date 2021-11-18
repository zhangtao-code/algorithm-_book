package cacpter1_3.common.link;

import cacpter1_3.common.Node;

public class DoubleLinkNode<T> implements LinkedNode<T> {
    protected Node<T>first;
    protected Node<T> last;

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

    }



    @Override
    public void removeAfter(int k) {
        
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
}
