package cacpter1.cacpter1_4;


import java.util.Arrays;

public class Homework1_4_19 {


    public static void main(String []args){
        int[][] matrix = {
                { 111,  122,  123,  42, 102 },
                { 53,  161,  721, 184, 101 },
                { 12, 125, 110, 189, 100 },
                { 14,  107,  871,  512,   104 },
                { 114,515, 568, 525,  99 }
        };
        System.out.println(min(matrix));
    }
    public static int min(int [][]array){
        int left=0;
        int right=array.length-1;
        int top=0;
        int bottom=array.length-1;
        int width=(left+right)>>1;
        int high=(top+bottom)>>1;
        while (true){
            left=width-1>=0?array[width-1][high]:Integer.MAX_VALUE;
           right= width+1<array.length?array[width+1][high]:Integer.MAX_VALUE;
            top = high - 1 >= 0 ? array[width][high - 1] :Integer.MAX_VALUE;
            bottom = high+1<array.length?array[width][high+1]:Integer.MAX_VALUE;
           int  []temp={left,right,bottom,top,array[width][high]};
            Arrays.sort(temp);
            if(temp[0]==left){
                width--;
            }else  if(temp[0]==right){
                width++;
            }else if(temp[0]==top){
                high--;
            }else if(temp[0]==bottom){
                high++;
            }else{
                return array[width][high];
            }
        }
    }
}
