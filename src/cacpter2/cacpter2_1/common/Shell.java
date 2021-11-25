package cacpter2.cacpter2_1.common;

public class Shell {
    public static void main(String[]args){
        int []array={1,342,546,67,78455,33,423,4234,45,34,5,57};
        long time=System.nanoTime();
        shellSort(array);
        System.out.println(System.nanoTime()-time);
        for (int i : array) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
    public static void shellSort(int []array){
        //int h=1;
      //  int []fi={0,1,2,3,5,8,13,21,34,55};
        //int []fi={0,1,3,9,12,15,18};
        int []fi={0,1,2,4,8,12,16};
        int k=0;
        while (fi[k]<array.length){
            k++;
        }
        while (fi[--k]>=1) {
            for (int i = fi[k]; i < array.length; i++) {
                for (int j = i; j >=  fi[k]; j-=fi[k]) {
                    if (array[j - 1] > array[j]) {
                        int temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    }
                }
            }
        }
    }
}
