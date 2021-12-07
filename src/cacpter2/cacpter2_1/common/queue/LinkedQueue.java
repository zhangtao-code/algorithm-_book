package cacpter2.cacpter2_1.common.queue;

import cacpter1.cacpter1_3.common.Node;

public class LinkedQueue {
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        int a[] = { 3412, 4, 32, 423, 42, 34, 234,4395,542,4,3,454};
        for (int i : a) {
            linkedQueue.insert(i);
        }
        Integer value = null;
        while ((value = linkedQueue.getMax()) != null) {
            System.out.print(value + "\t");
        }
    }

    protected Node<Integer> first;

    public void insert(int value) {
       first= insertNode(first, value);
    }

    public Node insertNode(Node<Integer> node, int value) {
        if (node == null) {
            return new Node<Integer>(value);
        }
        if (node.getT() > value) {
            node.setPre(insertNode(node.getPre(), value));
        } else {
            node.setNext(insertNode(node.getNext(), value));
        }
        return node;
    }

    public Integer getMax() {
        if (first == null) {
            return null;
        }
        if (first.getNext() == null && first.getPre() == null) {
            Integer value = first.getT();
            first = null;
            return value;
        }
        Node<Integer> current = first;
        while (current.getNext() != null) {
            Node<Integer> right = current.getNext();
            if (right.getNext() != null) {
                current = right;
            } else  {
                current.next = right.getPre();
                return right.getT();
            }
        }
        if (first.getNext() == current) {
            first.next = null;
            return current.getT();
        }
        Integer value = first.getT();
        first = first.getPre();
        return value;
    }

}
