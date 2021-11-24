package cacpter1.cacpter1_4;


public class Homework1_4_20 {


    public static void main(String []args){
        int []array1={1,2,5,7,9,8,6,4};
        int []array2={20,23,25,29,23,20};
        int []array3={1,2,3,4,5,6,7,8,9};
        int []array4={9,8,7,6,5,4,3,2,1};
        int []array5={1,10,8,7,6,5,4,3,2,1};
        System.out.println(find(array1,7));
        System.out.println(find(array1,17));
        System.out.println(find(array2,23));
        System.out.println(find(array2,223));
        System.out.println(find(array3,3));
        System.out.println(find(array3,31));
        System.out.println(find(array4,8));
        System.out.println(find(array4,-2));
        System.out.println(find(array5,1));
        System.out.println(find(array5,15));
    }
    public static int find(int []array,int value){
        int low=0;
        int high=array.length-1;
        int index=-1;
        //首先用二分法找出最大点
        while (low<=high){
            int mid=(low+high)>>1;
            if(array[mid]==value){
               index=mid;
               break;
            }
            if((((mid-1)>=0&&array[mid]>array[mid-1])||mid==0)&&((mid+1<array.length&&array[mid]>array[mid+1])||mid+1==array.length)){
                index=mid;
                break;
            }else if(mid-1>=0&&array[mid]<array[mid-1]){
               high=mid-1;
            }else {
                low=mid+1;
            }
        }
        //在递增序列中查找
        low=0;
        high=index;
        while (low<=high){
            int mid=(low+high)>>1;
            if(array[mid]==value){
                return mid;
            }else if(array[mid]>value){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        //在递减序列中查找
        low=index;
        high=array.length-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(array[mid]==value){
                return mid;
            }else if(array[mid]>value){
                low =mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
