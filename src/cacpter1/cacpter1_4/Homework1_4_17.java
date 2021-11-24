package cacpter1.cacpter1_4;

import java.util.Arrays;

public class Homework1_4_17 {


    public static void main(String []args){

    }
    public static double[] max(double []array){
        Arrays.sort(array);
        double value=-1;
        double []result=null;
        for (int i = 0; i < array.length-1; i++) {
            if(value<0){
                value=array[i+1]-array[i];
                continue;
            }
            double max=array[i+1]-array[i];
            if(max<value){
                result=new double[]{array[i],array[i+1]};
            }
        }
        return  result;
    }
}
