package cacpter1_3.common;

public class Node<T> {
    public Node<T>pre;
    public T t;
    public Node<T>next;

    public Node(Node<T> pre, T t) {
        this.pre = pre;
        this.t = t;
    }

    public Node(T t, Node<T> next) {
        this.t = t;
        this.next = next;
    }

    public Node(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }
}
