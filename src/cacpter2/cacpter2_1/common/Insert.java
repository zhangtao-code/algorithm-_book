package cacpter2.cacpter2_1.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Insert {
    public static void main(String []args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Collections.shuffle(list);
        int []array=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i]=list.get(i);
        }
        long time=System.nanoTime();
        insertSort(array);
        System.out.println(System.nanoTime()-time);
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static  void insertSort(int []array){//时间复杂度 n的平方
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >0; j--) {
                if(array[j-1]>array[j]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
}
