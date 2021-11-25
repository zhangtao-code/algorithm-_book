package cacpter2.cacpter2_1.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Merge {
    protected static  long all=0;
    public static void main(String []args){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Random().nextInt(1000));
        }
        Collections.shuffle(list);
        int []array=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i]=list.get(i);
        }
        int []clone=array.clone();
        for (int i : clone) {
           // System.out.print(i+"\t");
        }
        long time=System.nanoTime();

        mergeSort(clone);
        System.out.println(time+"\t\t\t"+(System.nanoTime()-time));

        System.out.println();
        clone=array.clone();
        for (int i : clone) {
          //  System.out.print(i+"\t");
        }
        time=System.nanoTime();

        Insert.insertSort(clone);
        System.out.println(time+"\t\t\t"+(System.nanoTime()-time));
        for (int i : clone) {
         //   System.out.print(i+"\t");
        }
        System.out.println();
        System.out.println(all);
    }
    public static  void mergeSort(int []array){//时间复杂度 n的平方
        sort(array,0,array.length-1,new int[array.length]);
    }
    public static void sort(int []array,int low,int high,int temp[]){
        if(low>=high){
            return;
        }
        int mid=(low+high)>>1;
        sort(array,low,mid,temp);
        sort(array,mid+1,high,temp);

        merge(array,low,mid,high,temp);
        //all+=System.nanoTime()-time;
    }
    public static void merge(int []array,int low,int mid,int high,int temp[]){
        if(low>=high){
            return;
        }
        if(array[mid+1]>=array[mid]){
            return;
        }else if(array[high]<=array[low]){
            for (int i = mid+1; i <=high; i++) {
                temp[i]=array[i];
            }
            for (int i = mid; i >=low; i--) {
                array[high-mid+i]=array[i];//平移过去
            }
            for (int i = low; i <low+high-mid; i++) {
                array[i]=temp[mid+1+i-low];
            }
            return;
        }
        if(high-low==1){
            if(array[high]<array[low]){
                int value=array[high];
                array[high]=array[low];
                array[low]=value;
            }
            return;
        }
        for (int i = low; i <=mid; i++) {
            temp[i]=array[i];
        }
        for (int i = mid+1; i <=high; i++) {
            temp[i]=array[high - i + mid + 1];
        }
        int i = low, j = high;      //从两端往中间
        for (int k = low; k <= high; k++)
            if (temp[i] <= temp[j]){ array[k] = temp[i++];}
            else {array[k] = temp[j--];}
    }
}
