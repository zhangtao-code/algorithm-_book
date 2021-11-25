package cacpter2.cacpter2_1;

import cacpter1.cacpter1_3.common.Node;
import cacpter1.cacpter1_3.common.link.DoubleLinkNode;


import java.util.Random;

public class Homework2_2_17 {
    public static void main(String[] args) {
        DoubleLinkNode<Integer>linkedNode=new DoubleLinkNode<>();
        Random random=new Random();

        for (int i = 0; i < 1000; i++) {
            int value=random.nextInt(100);
            linkedNode.insert(value);
           // System.out.print(value+"\t");
        }
        System.out.println();
       Node<Integer>node=sort(linkedNode.getFirst());
        int count=0;
        while (node!=null){
            System.out.print(node.getT()+"\t");
            node=node.getNext();
            count++;
            if(count%16==0){
                System.out.println();
            }
        }
        System.out.println();
    }
    protected static Node<Integer> sort(Node<Integer>first){
        if(first==null||first.next==null){
            return first;
        }
        Node<Integer>fast=first.next;
        Node<Integer>slow=first;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node<Integer>last= slow.next;
        slow.next=null;
        Node<Integer>left=sort(first);
        Node<Integer>right=sort(last);
        return merge(left,right);
    }
    protected static Node<Integer> merge(Node<Integer>left,Node<Integer>right){
        Node<Integer>first=null;
        Node<Integer>current=null;
        while (left!=null||right!=null){
            if(left==null){
                current.next=right;
                return first;
            }else if(right==null){
                current.next=left;
                return first;
            }else{
                if(left.getT()<=right.getT()){
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
