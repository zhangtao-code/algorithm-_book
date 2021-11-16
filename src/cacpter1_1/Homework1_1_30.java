package cacpter1_1;

public class Homework1_1_30 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i+"\t"+j+"\t"+zhishu(Math.max(i,j),Math.min(i,j)));
            }
        }
    }
    public static boolean zhishu(int x,int y){
        if(x<=1||y<=1||x==y){
            return false;
        }
        int euclid=euclid(x,y);
        return euclid!=1;
    }
    public static int euclid(int x,int y){
        x=x%y;
        if(x==0){
            return y;
        }
        return euclid(y,x);
    }
}
