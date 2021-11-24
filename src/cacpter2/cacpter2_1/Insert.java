package cacpter2.cacpter2_1;

public class Insert {
    public static void main(String []args){
        int []array={1,342,546,67,78455,33,423,4234,45,34,5,57};
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
