package cacpter1;

public class Homework1_1_24 {
    public static void main(String[] args) {
        for (int i = 2; i < 20; i++) {
            System.out.println(50+"\t"+i+"：\t"+euclid(50,i));
        }
    }
    public static int euclid(int x,int y){
        x=x%y;
        if(x==0){
            return y;
        }
        return euclid(y,x);
    }
}
