import java.lang.Math;

public class Recursion{

  public static String name(){
    return "Huang,Sihao";
  }

  public static double sqrt(double n){
    return squareRoot(n,n/2);
  }

  public static double squareRoot(double n, double guess){
    if((Math.abs(guess*guess-n)/n)<0.00000000001) return guess;
    else return squareRoot(n,0.5*((n/guess)+guess));
  }

  public static void main(String[] args){
    System.out.println(sqrt(3));
  }

}