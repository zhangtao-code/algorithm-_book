package cacpter1_3;


import java.util.ArrayList;
import java.util.List;

public class Homework1_3_45 {
    public static void main(String[]args){
        List<String>list=new ArrayList<>();
        list.add("-----wqe-weqwe");
        list.add("w-w-w-w-w-w-w-w-w-");
        list.add("w---www--ee");
        list.add("wwwww----w--");
        list.add("wqewq----weqw--");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+"\t\t"+yichu(list.get(i)));
        }
    }
    public static boolean yichu(String value){
        int pop=0;
        int push=0;
        for (int i = 0; i < value.length(); i++) {
            char c=value.charAt(i);
            if(c=='-'){
                pop++;
                if(pop>push){
                    return false;
                }
            }else{
                push++;
            }
        }
        return true;
    }

}
