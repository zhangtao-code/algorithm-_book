package cacpter2.cacpter2_1.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quick {
    public static void main(String[]args){
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
        quickSort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static void  quickSort(int[] array){
        if(array==null||array.length<=1){
            return;
        }
        quick(array,0,array.length-1);
    }
    public static void quick(int []array,int low,int high){
        if(low>=high){
            return;
        }
        int mid=quickSort(array,low,high);
        quick(array,low,mid-1);
        quick(array,mid+1,high);

    }
    public static int quickSort(int []array,int low,int high){

        int left=low;
        int right=high+1;
        int value=array[low];
        while (true){
            while (array[++left]<value){
                if(left==high){
                    break;
                }
            }
            while (array[--right]>value){
                if(right==low){
                    break;
                }
            }
            if(left>=right){
                break;
            }
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
        }
        int temp=array[low];
        array[low]=array[right];
        array[right]=temp;
        return right;
    }

}
