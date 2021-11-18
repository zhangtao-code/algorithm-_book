package cacpter1_3;

import cacpter1_3.common.LinkedStack;
import cacpter1_3.common.Stack;

import java.util.*;

public class Homework1_3_4 {
    public static Set<Character>left=new HashSet<>();
    public static Set<Character>right=new HashSet<>();
    public static Map<Character,Character>map=new HashMap<>();
    static {
        init();
    }

    public static void  init(){
        left.add('[');
        left.add('{');
        left.add('(');
        right.add(']');
        right.add('}');
        right.add(')');
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
    }
    public static void main(String []args){
        List<String>list=new ArrayList<>();
        list.add("[][][][]{}{}{}()()");
        list.add("[()][][]{[]}({[]})");
        list.add("([)]]");
        list.add("[()");
        for (String s : list) {
            System.out.println(s+":\t"+isRight(s));
        }
    }
    public static  boolean isRight(String value){
        Stack<Character>stack=new LinkedStack<>();
        for (int i = 0; i < value.length(); i++) {
            char c=value.charAt(i);
            if(left.contains(c)){
                stack.push(c);
            }else if(right.contains(c)){
                Character character=stack.pop();
                if(character==null){
                    return false;
                }
                char m=map.get(character);
                if(m!=c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
