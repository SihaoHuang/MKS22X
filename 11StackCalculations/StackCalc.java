import java.util.*;
public class StackCalc{
    public static Double apply(String op, Double a, Double b){
        if(op.equals("+")) return a + b;
        else if(op.equals("-")) return b - a;
        else if(op.equals("*")) return a * b;
        else if(op.equals("/")) return b / a;
        else if(op.equals("%")) return b % a;
        else return 0.00001234; // for debugging, just in case
    }

    public static boolean isOp(String s){
        return(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%"));
    }

    public static Double eval(String s){
        String[] input = s.split(" ");
        Stack buffer = new Stack();
        for(String each:input){
            if(isOp(each)) buffer.push(apply(each, (Double)buffer.pop(), (Double)buffer.pop()));
            else buffer.push(Double.parseDouble(each));
        }
        return (Double)buffer.pop();
    }

    // public static void main(String[] args){
    //     System.out.println(eval("1 5 4 + -12.2 * /"));
    //     System.out.println(eval("1 2 +"));
    // }
}