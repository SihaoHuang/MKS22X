import java.lang.Math;
import java.util.Arrays;
public class Quick{

  public static int[] part(int[] data, int start, int end){
    int pivotInd = (int)(Math.random() * ((double)end - (double)start) + (double)start);
    int pivot = data[pivotInd];
    int lt = start;
    int i = start;
    int gt = end;
    while(i < gt){
      if(data[i] == pivot) i++;
      else if(data[i] < pivot){
        int temp = data[i];
        data[i] = data[lt];
        data[lt] = temp;
        i ++;
        lt ++;
      }
      else{
        int temp = data[i];
        data[i] = data[gt];
        data[gt] = temp;
        gt --;
      }
    }
    int[] ans = {lt, gt};
    return ans;
  }

  public static int quickselect(int[] data, int k){
    return quickselectH(data, 0, data.length - 1, k); //check this too
  }

  public static int quickselectH(int[] arr, int left, int right, int k){
    int[] pivots = part(arr, left, right);
    int pivot = pivots[0] + pivots[1];
    if(pivot == k) return arr[k];
    if(pivot < k) return quickselectH(arr, left + 1, right, k);
    else return quickselectH(arr, left, right - 1, k);    
  }

  public static int[] quicksort(int[] data){
    return quicksortH(data, 0, data.length - 1); //check if this has to be length - 1
  }

  public static int[] quicksortH(int[] arr, int left, int right){
    if(left < right){
      int[] ind = part(arr, left, right);
      quicksortH(arr, ind[1] + 1, right); 
      quicksortH(arr, left, ind[0] - 1);
    }
    return arr;
  }

  public static int[] randomArray(int size){
    int[] arr = new int[size];
    for(int i = 0; i < size; i ++){
      if((int)(Math.random() * 2) == 1){
        arr[i] = (int)(Math.random() * 2.0);
      }
      else{
        arr[i] = -(int)(Math.random() * 1000.0);
      }
    }
    return arr;
  }

  public static void main(String[] args){
    //[25, 24, 4, 77, 86, 61, 40, 11, 1, 30] 
    int size = Integer.parseInt(args[0]);
    int[] test = randomArray(size);
    //System.out.println(Arrays.toString(test));
    // quicksort(test);
    // System.out.println("done");
    System.out.println(Arrays.toString(quicksort(test)));
    int[] test2 = {25, 24, 4, 77, 86, 61, 40, 11, 1, 30};
    System.out.println(quickselect(test2, 1));
  }

}