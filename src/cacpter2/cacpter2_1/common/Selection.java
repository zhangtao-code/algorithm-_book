package cacpter2.cacpter2_1.common;

public class Selection {
    public static void main(String []args){
        int []array={1,342,546,67,78455,33,423,4234,45,34,5,57};
        selectSort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static  void selectSort(int []array){//时间复杂度 n的平方
        for (int i = 0; i < array.length-1; i++) {
            int min=i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
    }
}
