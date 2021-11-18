package cacpter1_3.common;

import java.util.Iterator;

public class IteratorArray<T> implements Iterator<T> {
    protected Object[]array;
    protected int point;
    public IteratorArray(Object[] array) {
        this.array = array;
        point=array.length;
    }

    @Override
    public boolean hasNext() {
        return point<array.length&&point>0;
    }

    @Override
    public T next() {
        return(T) array[--point];
    }
}
