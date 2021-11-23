package cacpter1_4;

import java.util.Arrays;

public class Homework1_4_22 {


    public static void main(String []args){
        int []array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        for (int i = 0; i < 25; i++) {
            System.out.println(i+"\t"+feibona(array,i));
        }
    }
    public static int feibona(int []array,int value){
        int []fi=fi();
        int left=0;
        int right=array.length-1;
        int k=0;
        while (array.length>fi[k]-1){
            k++;
        }
        int []temp=Arrays.copyOf(array,fi[k]);
        for (int i = right+1; i < temp.length; i++) {
            temp[i]=temp[right];
        }
        while (left<=right){
            int index=left+fi[k]-1;
            if(temp[index]>value){
                right=index-1;
                k--;
            }else if(temp[index]<value){
                left=index+1;
                k-=2;
            }else{
                if(index<array.length){
                    return index;
                }else{
                    return right;
                }
            }
        }
        return -1;
    }
    public static int []fi(){
        int []array=new int[100];
        array[0]=1;
        array[1]=1;
        for (int i = 2; i < array.length; i++) {
            array[i]=array[i-1]+array[i-2];
        }
        return array;
    }
}
