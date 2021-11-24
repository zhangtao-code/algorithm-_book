package cacpter2.cacpter2_1;

public class Merge {
    public static void main(String []args){
        int []array={1,342,546,67,78455,33,423,4234,45,34,5,57};
        long time=System.nanoTime();
        mergeSort(array);
        System.out.println(System.nanoTime()-time);
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println();
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
    }
    public static void merge(int []array,int low,int mid,int high,int temp[]){
        if(low>=high){
            return;
        }
        for (int i = low; i <=high; i++) {
            temp[i]=array[i];
        }
        int left=low;
        int right=mid+1;
        for (int i = low; i <=high; i++) {
            int index=i;
            if(left>mid){
                array[index]=temp[right++];
            }else if(right>high){
                array[index]=temp[left++];
            }else{
                if(temp[left]>temp[right]){
                   array[index]= temp[right++];
                }else{
                    array[index]= temp[left++];
                }
            }
        }

    }
}
