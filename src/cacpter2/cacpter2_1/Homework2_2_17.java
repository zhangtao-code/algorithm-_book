package cacpter2.cacpter2_1;

import cacpter1.cacpter1_3.common.link.DoubleLinkNode;
import cacpter1.cacpter1_3.common.link.LinkedNode;

import java.util.Random;

public class Homework2_2_17 {
    public static void main(String[] args) {
        LinkedNode<Integer>linkedNode=new DoubleLinkNode<>();
        Random random=new Random();

        for (int i = 0; i < 10; i++) {
            int value=random.nextInt(1000);
            linkedNode.insert(value);
            System.out.print(value+"\t");
        }
        System.out.println();

    }
    protected static void sort(LinkedNode<Integer>linkedNode){

    }

}
