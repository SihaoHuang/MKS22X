public class Recursion{

  public static long factorial(int n){
    if(n < 2){
      return 1;
    }
    else {
      return n*factorial(n-1);
    }
  }

  public static long factorialNew(int n, int ans){
    if(n < 2){
      return ans;
    }
    else {
      return factorialNew(n - 1, n * ans);
    }
  }

  public static int countX(String s){
    if(s.length() == 0){
      return 0;
    }
    else{
      String first = s.substring(0,1);
      if (first.equals("x")) {
        return 1 + countX(s.substring(1));
      }
      return countX(s.substring(1));
    }
  }

  public static void main(String[] args){
    System.out.println(factorialNew(20,1));
    System.out.println(countX("xxxXAklaFXxX"));
  }

}