package cacpter1.cacpter1_1;

public class Homework1_1_25 {
    public static void main(String[] args) {
        int []array={1,2,2,3,4,5,5,6,7,8,9,9,10};
        array=remove(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }
    public static int[] remove(int []array){
        int []temp=new int[array.length];
        temp[0]=array[0];
        int count=1;
        for (int i = 1; i < array.length; i++) {
            if(temp[count-1]==array[i]){
                continue;
            }
            temp[count++]=array[i];
        }
        if(count==temp.length){
            return temp;
        }
        int []result=new int[count];
        for (int i = 0; i < count; i++) {
            result[i]=temp[i];
        }
        return result;
    }
}
