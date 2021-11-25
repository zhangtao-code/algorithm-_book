package cacpter2.cacpter2_1;

import cacpter2.cacpter2_1.common.Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Homework2_2_14 {
    public static void main(String[]args){
        for (int i = 0; i < 10000; i++) {
            demo();
            System.out.println();
            System.out.println("--------------------------------------");
        }

    }
    public static void demo(){
        List<int[]>list=new ArrayList<>();
        int count=productList(list);
        int []array=merge(list);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t\t");
            if(i!=0&&i%10==0){
                System.out.println();
            }
            if(i!=0&&array[i]<array[i-1]){
                System.out.println("error");
            }
        }
    }

    public static int []merge(List<int[]>list){
        if(list.size()==0){
            return new int[0];
        }
       int []array=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            array=merge(array,list.get(i));
        }
        return array;
    }
    public static int[] merge(int []array1,int []array2){
        int length=array1.length+array2.length;
        int []array=new int[length];
        if(array1[0]>=array2[array2.length-1]){
            int i=0;
            for (; i < array2.length; i++) {
                array[i]=array2[i];
            }
            for (; i < length; i++) {
                array[i]=array1[i- array2.length];
            }
            return array;
        }else if(array2[0]>=array1[array1.length-1]){

            int i=0;
            for (; i < array1.length; i++) {
                array[i]=array1[i];
            }
            for (; i < length; i++) {
                array[i]=array2[i- array1.length];
            }
            return array;
        }
        int j=0;
        int k=0;
        for (int i = 0; i < length; i++) {
            if(j>=array1.length){
                array[i]=array2[k++];
            }else if(k>= array2.length){
                array[i]=array1[j++];
            }else{
                if(array1[j]>=array2[k]){
                    array[i]=array2[k++];
                }else{
                    array[i]=array1[j++];
                }
            }
        }
        return array;
    }

    public static int productList(List<int[]>list){
        int count=0;
        Random random=new Random();
        int value=random.nextInt(20);
        for (int i = 0; i < value; i++) {
            int length=random.nextInt(35);
            if(length==0){
                continue;
            }
            int []array=new int[length];
            for (int j = 0; j < length; j++) {
                array[j]=random.nextInt(10000);
            }
            Merge.mergeSort(array);
            list.add(array);
            count+=length;
        }
        return count;
    }
}
