package cacpter1_3;

import cacpter1_3.common.stack.FixCapacityStack;
import cacpter1_3.common.stack.LinkedStack;
import cacpter1_3.common.stack.Stack;


public class Dijkstra {
    public static void main(String[]args){
        System.out.println(execute("(((1+(2*3))+11.3)/3.0)"));
    }
    public static double execute(String express){
        Stack<Double> stack=new FixCapacityStack<>(2);
        Stack<Character>opStack=new LinkedStack<>();
        for (int i = 0; i < express.length(); i++) {
            char  c=express.charAt(i);
            if(c>='0'&&c<='9'){
                String number=c-'0'+"";
                while ((express.charAt(i+1)>='0'&&express.charAt(i+1)<='9')||express.charAt(i+1)=='.'){
                    number+=express.charAt(++i);
                }
                double value=Double.parseDouble(number);
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
