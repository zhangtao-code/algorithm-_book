package cacpter1.cacpter1_4;

public class Homework1_4_24 {
    public static void main(String []args){
        int n=100;
        for (int i = 1; i <10; i++) {
            int temp=i;
            int value=eggs(n,i);
            System.out.println(value==i);

        }
    }
    public static int eggs(int n, int k){
        int low=1;
        int high=n;
        while (low<high){
            int mid=(low+high)>>1;
            if(mid<k){//没破
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }

}
