import java.lang.Math;

public class Recursion{

  public static String name(){
    return "Huang,Sihao";
  }

  public static double sqrt(double n){
    if (n < 0.0) throw new IllegalArgumentException();
    if (n == 0.0) return 0.0;
    else return squareRoot(n,n/2);
  }

  public static double squareRoot(double n, double guess){
    if((Math.abs(guess*guess-n)/n)<0.00000000001) return guess;
    else return squareRoot(n,0.5*((n/guess)+guess));
  }

  public static void main(String[] args){
    System.out.println(sqrt(4.0));
  }

}