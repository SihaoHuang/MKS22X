import java.lang.Math;
import java.util.Arrays;
public class Quick{
  public static int part(int[] data, int start, int end){
    int pivotInd = (int)(Math.random() * ((double)end - (double)start) + (double)start);
    //int pivotInd = 1;
    int pivot = data[pivotInd];
    data[pivotInd] = data[start];
    data[start] = pivot;
    int a = start + 1;
    int b = end;
    while(a <= b){
      System.out.println("a is "  + a);
      System.out.println("b is "  + b);
      System.out.println(Arrays.toString(data));
      if(data[a] < pivot) a++;
      else {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp; 
        b--;
      }
      if(data[b] > pivot) b--;
      else {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp; 
        a++;
      }
    }
    System.out.println(Arrays.toString(data));
    data[start] = data[a - 1];
    data[a - 1] = pivot;

    return a;
  }

  //dump value to one end, then split array into greater and less than value around its index
  //val, [< v], a, ???, b, [> v]
  //arr[a] < a then a++;
  //arr[a] >= v then swap(arr[a], arr[b]) and do b--;
  //look through ???. if it is less than v then increment index of a, if it si more than v then swap with the value in front of b
  //finally swap val with the 
  //for duplicates, it only has to go consistently on the same side

  //public static int quickselect(int[] data, int k){
    //partition until the kth spot is partitioned
  //}

  public static int[] quicksortH(int[] arr, int left, int right){
    //partition into two halves, then parition each into two halves, etc, recursively
    //stops when the part only has one element
    // --------------------
    // -------------*------
    // ---*---------*---*--
    // -*-*---*-----*-*-**-
    if(left < right){
      int p = part(arr, left, right);
      quicksortH(arr, p + 1, right); //might not need the +- 1 or might be at different points
      quicksortH(arr, left, p - 1);
    }
    return arr;
  }

  public static int[] quicksort(int[] data){
    return quicksortH(data, 0, data.length); //check if this has to be length - 1
  }

  public static void main(String[] args){
    //int[] test = {-13,0,9,8,3,-2,6,5,7,12};
    int[] test = {9,8,7,6,5,4,3,2,1,0};
    System.out.println(part(test, 0, 9));
    System.out.println(Arrays.toString(test));
  }

}