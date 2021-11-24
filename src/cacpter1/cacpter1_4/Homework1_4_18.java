package cacpter1.cacpter1_4;



public class Homework1_4_18 {


    public static void main(String []args){
        int []array={1,2,3,4,5,6,7,8};
        int []array1={8,7,6,5,4,3,2,1};
        int []array2={23,34,3243,43,4,2,543,423};
        int []array3={2,32232,46,8745,6,7634,554,64,254,23423,54,5,23};
        int []array4={8745,6,7634,554,64,254,23423,54,5,23,9828,23912,93,32,3283,55,5743,4524,56,87,8,436644};
        System.out.println(min(array));
        System.out.println(min(array1));
        System.out.println(min(array2));
        System.out.println(min(array3));
        System.out.println(min(array4));
    }
    public static int min(int []array){
        int low=0;
        int high=array.length-1;
        while (low<high){
            int mid=(low+high)>>1;
            if(array[mid]>array[mid-1]){
                high=mid-1;
            }else if(array[mid]>array[mid+1]){
                low=mid+1;
            }else {
                return array[mid];
            }
        }
        return array[(low+high)>>1];
    }
}
