package cacpter1_3;

import cacpter1_3.common.FixCapacityStack;
import cacpter1_3.common.LinkedStack;
import cacpter1_3.common.Stack;


public class Homework1_3_11 {
    public static void main(String[]args){
        System.out.println(execute("(((1\t(2\t3\t*)\t+)\t2\t+)\t3\t/)"));
    }
    public static Double  execute(String express){
        Stack<Double> stack=new FixCapacityStack<>(2);
        Stack<Character>opStack=new LinkedStack<>();
        for (int i = 0; i < express.length(); i++) {
            char  c=express.charAt(i);
            if(c>='0'&&c<='9'){
                double value=c-'0';
                stack.push(value);
            }else if (c=='+'||c=='-'||c=='*'||c=='/'){
                opStack.push(c);
            }else if(c==')'){
                double right=  stack.pop();
                double left=  stack.pop();
                char op=opStack.pop();
                if(op=='+'){
                    stack.push(left+right);
                }else if(op=='-'){
                    stack.push(left-right);
                }else if(op=='*'){
                    stack.push(left*right);
                }else if(op=='/'){
                    stack.push(left/right);
                }
            }
        }
        return  stack.pop();
    }
}
