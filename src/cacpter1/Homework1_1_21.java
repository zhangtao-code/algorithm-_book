package cacpter1;

import java.util.Random;

public class Homework1_1_21 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printf("i->"+i,new Random().nextInt(100),new Random().nextInt(200));
        }
    }

   public static void printf(String name,double x,double y){
        String value=String.format("%s:\t%.3f",name,x/y);
        System.out.println(value);
   }
}
