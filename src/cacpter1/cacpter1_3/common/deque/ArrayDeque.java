package cacpter1.cacpter1_3.common.deque;

public class ArrayDeque<T> implements Deque<T>{
    protected Object[]array;
    protected int factor;
    protected int size;
    protected int left;//exclude;
    protected int right;//include;

    public ArrayDeque(int cap,int factor) {
       array=new Object[cap];
       this.factor=factor;
    }


    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pushLeft(T t) {
        if(size>=array.length){
            resize();
        }

    }

    @Override
    public void pushRight(T t) {
        if(size==array.length){
            resize();
        }
    }

    @Override
    public T popLeft() {
        return null;
    }

    @Override
    public T popRight() {
        return null;
    }
    public void resize(){

    }
}
