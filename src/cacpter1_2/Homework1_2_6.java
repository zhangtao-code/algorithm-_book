package cacpter1_2;

import java.util.LinkedList;
import java.util.List;


public class Homework1_2_6 {
    public static void main(String[] args) {
        System.out.println(huan("abcdefghijk","defghijkabc"));
        System.out.println(huan("abcdefghijk","defghijkabv"));
    }
    public static boolean huan(String value1,String value2){
        if(value1.length()!=value2.length()){
            return false;
        }
        if(value1.equals(value2)) {
            return true;
        }
        LinkedList<Character>list=new LinkedList<>();
        for (int i = 0; i < value1.length(); i++) {
            list.add(value1.charAt(i));
        }
        for (int i = 0; i < value1.length(); i++) {
           char ch= list.removeLast();
           list.addFirst(ch);
           if(check(list,value2)){
               return true;
           }
        }
        return false;
    }
    public static boolean check(List<Character> list,String value){
        int index=0;
        for (Character character : list) {
            char c=value.charAt(index++);
            if(c!=character){
                return false;
            }
        }
        return true;
    }
}
