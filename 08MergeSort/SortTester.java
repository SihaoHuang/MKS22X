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
    
    System.out.println("Random array with large range");
    int[] test = randomArrayBig(Integer.parseInt(args[0]));
    long start = System.nanoTime(); 
    Merge.mergesort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Random array with small range");
    test = randomArraySmall(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Merge.mergesort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Array with the same elements");
    test = sameArray(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Merge.mergesort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Sorted array");
    test = sorted(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Merge.mergesort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);

    System.out.println("Reverse sorted array");
    test = reverseSorted(Integer.parseInt(args[0]));
    start = System.nanoTime(); 
    Merge.mergesort(test);
    elapsed = System.nanoTime() - start;
    System.out.println("Time elapsed: " + elapsed);
  }
}