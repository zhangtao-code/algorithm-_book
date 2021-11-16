package cacpter1_1;

public class Homework1_1_29 {
    public static void main(String[] args) {
        int []array={1,2,2,3,4,5,5,6,7,8,9,9,10};
        for (int i = 0; i <= 10; i++) {
            System.out.print(i+"->\t"+rank(array,i)+"\t\t\t");
            System.out.println(i+"->\t"+count(array,i));
        }
    }
    public static int rank(int []array,int key){
        int low=0;
        int high=array.length-1;
        int index=-1;
        while (low<=high){
            int mid=(low+high)>>1;
           // System.out.println(mid);
            if(array[mid]>key){
                high=mid-1;
            }else if(array[mid]<key){
                low=mid+1;
            }else {
                index=mid;
                break;
            }
        }
        if(index<0){
            return 0;
        }
        for (int i = index-1; i >=0; i--) {
            if(array[i]!=array[index]){
                break;
            }
            index--;
        }
        return index;
    }
    public static int count(int []array,int key){
        int low=0;
        int high=array.length-1;
        int index=-1;
        while (low<=high){
            int mid=(low+high)>>1;
            // System.out.println(mid);
            if(array[mid]>key){
                high=mid-1;
            }else if(array[mid]<key){
                low=mid+1;
            }else {
                index=mid;
                break;
            }
        }
        if(index<0){
            return 0;
        }
        int count=1;
        for (int i = index-1; i >=0; i--) {
            if(array[i]!=array[index]){
                break;
            }
            count++;
        }
        for (int i = index+1; i <array.length; i++) {
            if(array[i]!=array[index]){
                break;
            }
            count++;
        }
        return count;
    }
}
