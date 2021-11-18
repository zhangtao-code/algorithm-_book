package cacpter1_3;

import cacpter1_3.common.stack.FixCapacityStack;
import cacpter1_3.common.stack.LinkedStack;
import cacpter1_3.common.stack.Stack;


public class Homework1_3_10 {
    public static void main(String[]args){
        System.out.println(execute("(((1+(2*3))+11.3)/3.0)"));
    }
    public static String  execute(String express){
        Stack<String> stack=new FixCapacityStack<>(2);
        Stack<Character>opStack=new LinkedStack<>();
        for (int i = 0; i < express.length(); i++) {
            char  c=express.charAt(i);
            if(c>='0'&&c<='9'){
                String number=c-'0'+"";
                while ((express.charAt(i+1)>='0'&&express.charAt(i+1)<='9')||express.charAt(i+1)=='.'){
                    number+=express.charAt(++i);
                }

                stack.push(number);
            }else if (c=='+'||c=='-'||c=='*'||c=='/'){
                opStack.push(c);
            }else if(c==')'){
                String right=  stack.pop();
                String left=  stack.pop();
              char op=opStack.pop();
              stack.push("("+left+"\t"+right+"\t"+op+")");
            }
        }
        return  stack.pop();
    }
}
