package cacpter1_3.common.link;

import cacpter1_3.common.Node;

public interface LinkedNode<T> {

     void deleteLast();
     void delete(int k);
     boolean find(T t);
     void  remove(T t);
     void removeAfter(int k);
     void insertAfter(LinkedNode<T>linkedNode);
     Node<T> getFirst();
     Node<T> getLast();
}
