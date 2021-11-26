package cacpter2.cacpter2_1;

import cacpter1.cacpter1_3.common.Node;
import cacpter1.cacpter1_3.common.link.DoubleLinkNode;

import java.util.Random;

public class Homework2_2_18 {
    public static void main(String[] args) {
        DoubleLinkNode<Integer>linkedNode=new DoubleLinkNode<>();
        Random random=new Random();

        for (int i = 0; i < 30; i++) {

            linkedNode.insert(i);

        }
        System.out.println();
       Node<Integer>node=shuffle(linkedNode.getFirst());
        int count=0;
        while (node!=null){
            System.out.print(node.getT()+"\t");
            node=node.getNext();
            count++;
            if(count%15==0){
                System.out.println();
            }
        }
        System.out.println();
    }
    protected static Node<Integer> shuffle(Node<Integer>first){
        if(first==null||first.next==null){
            return first;
        }
        Node<Integer>fast=first.next;
        Node<Integer>slow=first;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node<Integer>temp= slow.next;
        slow.next=null;
        return shuffle( shuffle(first),shuffle(temp));
    }
    protected static Node<Integer> shuffle(Node<Integer>left,Node<Integer>right){
        Node<Integer>first=null;
        Node<Integer>current=null;
        while (left!=null||right!=null){
            if(left==null){
                if(current==null){
                    return right;
                }
                current.next=right;
                return first;
            }else if(right==null){
                if(current==null){
                    return left;
                }
                current.next=left;
                return first;
            }else{
                if(new Random().nextBoolean()){
                    if(current==null){
                        Node<Integer>next=left.next;
                        current=left;
                        left.next=null;
                        left=next;
                        first=current;
                    }else{
                        Node<Integer>next=left.next;
                        left.next=null;
                        current.next=left;
                        current=left;
                        left=next;
                    }
                }else{
                    if(current==null){
                        Node<Integer>next=right.next;
                        current=right;
                        right.next=null;
                        right=next;
                        first=current;
                    }else{
                        Node<Integer>next=right.next;
                        right.next=null;
                        current.next=right;
                        current=right;
                        right=next;
                    }
                }
            }
        }
        return first;
    }

}
