package cacpter2.cacpter2_1;

import java.util.Random;

public class Homework2_2_20 {
    public static void main(String[] args) {
        int []array=new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i]=new Random().nextInt(150);
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
       int []result=sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[result[i]]+"\t");
        }
        System.out.println();
    }
    public static int [] sort(int []array){
        Node []nodeArray=new Node[array.length];
        Node []temp=new Node[array.length];
        for (int i = 0; i < nodeArray.length; i++) {
            Node node=new Node(i,array[i]);
            nodeArray[i]=node;
        }
        mergeSort(nodeArray,temp);
        int []result=new int[array.length];
        for (int i = 0; i < nodeArray.length; i++) {
           System.out.print(nodeArray[i].getValue()+"\t");
            result[i]=nodeArray[i].getIndex();
        }
        System.out.println();
        return result;
    }
    public static void mergeSort(Node[]array,Node[]temp){
        if(array.length<=1){
            return;
        }
        int low=0;
        int high=array.length-1;
        mergeSort(array,low,high,temp);
    }
    public static void mergeSort(Node[]array,int low,int high,Node[]temp){
        if(low>=high){
            return;
        }
        int mid=(low+high)>>1;
        mergeSort(array,low,mid,temp);
        mergeSort(array,mid+1,high,temp);
        merge(array,low,mid,high,temp);
    }
    public static void merge(Node[]array,int low,int mid,int high,Node[]temp){
        if(low>=high){
            return;
        }
        if(array[mid].getValue()<=array[mid+1].getValue()){
            return;
        }
        if(high-low==1){
            if(array[low].value>array[high].value){
                Node node=array[low];
                array[low]=array[high];
                array[high]=node;
            }
            return;
        }
        if(array[high].getValue()<=array[low].getValue()){
            for (int i = mid+1; i <=high; i++) {//首先拷贝一份
                temp[i]=array[i];
            }
            int value=high-mid;
            for (int i = mid; i >= low; i--) {//前部分后移
                array[i+value]=array[i];
            }
            value=mid-low+1;
            for (int i = high; i >mid; i--) {//后部分前移
                array[i-value]=temp[i];
            }
            return;
        }
        for (int i = low; i <=mid; i++) {
            temp[i]=array[i];
        }
        int index=high;
        for (int i = mid+1; i <= high; i++) {
            temp[i]=array[index--];
        }
        int j=low;
        int k=high;
        for (int i = low; i <=high; i++) {
            if(temp[j].getValue()<=temp[k].getValue()){
                array[i]=temp[j++];
            }else {
                array[i]=temp[k--];
            }
        }
    }


}
class Node{
    public int index;
    public int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
