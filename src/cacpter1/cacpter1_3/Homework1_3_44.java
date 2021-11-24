package cacpter1.cacpter1_3;


import cacpter1.cacpter1_3.common.stack.FixCapacityStack;
import cacpter1.cacpter1_3.common.stack.LinkedStack;
import cacpter1.cacpter1_3.common.stack.Stack;

public class Homework1_3_44 {
    public static void main(String[]args){
        TextEditBuffer buffer=new TextEditBuffer();
        buffer.insert('a');
        buffer.insert('e');
        buffer.insert('h');
        buffer.insert('i');
        System.out.println(buffer);
        buffer.left(2);
        buffer.insert('f');
        buffer.insert('g');
        System.out.println(buffer);
        buffer.right(4);
        buffer.delete();
        System.out.println(buffer.toString());
        buffer.insert('i');
        buffer.insert('j');
        buffer.insert('k');
        System.out.println(buffer.toString());
    }
}
class TextEditBuffer {
    protected Stack<Character>left=new FixCapacityStack<>(20);
    protected Stack<Character>right=new LinkedStack<>();

    public  void insert(char c){
        left.push(c);
    }
    public char delete(){
      return   left.pop();
    }
    public void left(int k){
        while (k>0){
            Character character=left.pop();
            if(character==null){
                return;
            }
            right.push(character);
            k--;
        }
    }
    public void right(int k){
        while (k>0){
            Character character=right.pop();
            if(character==null){
                return;
            }
            left.push(character);
            k--;
        }
    }
    public int size(){
       return left.size()+ right.size();
    }
    public String toString(){
        Character character=null;
        String value="";
        if(!left.isEmpty()){
            Stack<Character>stack=LinkedStack.copy(left);
            Stack<Character>reverse=new LinkedStack<>();
            while ((character=stack.pop())!=null){
                reverse.push(character);
            }
            while((character=reverse.pop())!=null){
                value+=character;
            }
        }
        if(right.isEmpty()){
            return value;
        }
        Stack<Character>stack=LinkedStack.copy(right);
        while ((character=stack.pop())!=null){
            value+=character;
        }
        return value;
    }
}