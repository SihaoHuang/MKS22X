import java.util.*;
public class SortTester{
    public static int[] randomArrayBig(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      if((int)(Math.random() * 2) == 1){
        arr[i] = (int)(Math.random() * 2.0);
      }
      else{
        arr[i] = -(int)(Math.random() * 100000.0);
      }
    }
    return arr;
  }

  public static int[] randomArraySmall(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      if((int)(Math.random() * 2) == 1){
        arr[i] = (int)(Math.random() * 2.0);
      }
      else{
        arr[i] = -(int)(Math.random() * 10.0);
      }
    }
    return arr;
  }

  public static int[] sameArray(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      arr[i] = 1;
    }
    return arr;
  }

  public static int[] sorted(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      arr[i] = i;
    }
    return arr;
  }

  public static int[] reverseSorted(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      arr[i] = size - i;
    }
    return arr;
  }

  public static void main(String[] args){
    long elapsed;

    int[] test = {1,5,7,8,21,4,8,9,4,23,4,7,9,3,1,3,7,9,2};
    Quick.quicksort(test);
    System.out.println(Arrays.toString(test));
    
    System.out.println("Random array with large range");
    test = randomArrayBig(Integer.parseInt(args[0]));
    long start = System.nanoTime(); 
    Quick.quicksort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Random array with small range");
    test = randomArraySmall(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Quick.quicksort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Array with the same elements");
    test = sameArray(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Quick.quicksort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Sorted array");
    test = sorted(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Quick.quicksort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Reverse sorted array");
    test = reverseSorted(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Quick.quicksort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);
  }
}