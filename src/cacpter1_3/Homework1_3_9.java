package cacpter1_3;

import cacpter1_3.common.stack.FixCapacityStack;
import cacpter1_3.common.stack.LinkedStack;
import cacpter1_3.common.stack.Stack;

public class Homework1_3_9 {

    public static void main(String []args){
       String express="1+2)*3-4)*5-6)))";
       System.out.println(update(express));
    }

    public static  String  update(String express){
        Stack<String>number=new FixCapacityStack<>(20);
        Stack<Character>operation=new LinkedStack<>();
        for (int i = 0; i < express.length(); i++) {
            char current=express.charAt(i);
            if(current>='0'&&current<='9'){
                number.push(current+"");
            }else if(current=='+'||current=='-'||current=='*'||current=='/'){
                operation.push(current);
            }else if(current==')'){
                String right=number.pop();
                String left=number.pop();
                String value="("+left+operation.pop()+right+")";
                number.push(value);
            }
        }
        return number.pop();

    }
}
