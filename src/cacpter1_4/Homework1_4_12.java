package cacpter1_4;

public class Homework1_4_12 {


    public static void main(String []args){
        int []array1={1,2,3,4,5,6,7,8,13};
        int []array2={7,8,10,11,12,13};
        gonggong(array1,array2);
    }
    public static void gonggong(int []array1,int []array2){
        int index1=0;
        int index2=0;
        while (index1<array1.length&&index2<array2.length){
            if(array1[index1]>array2[index2]){
                index2++;
            }else if(array1[index1]<array2[index2]){
                index1++;
            }else{
                System.out.println(array1[index1]);
                index1++;
                index2++;
            }
        }
        return;
    }
}
