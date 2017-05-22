import java.lang.Math;
import java.util.*;
public class Quick{
  public static int[] part(int[] data, int start, int end){
    int pivotInd = (int)(Math.random() * ((double)end - (double)start) + (double)start);
    int pivot = data[pivotInd];
    int lt = start;
    int i = start;
    int gt = end;
    while(i <= gt){
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
    int pivotS = pivots[0];
    int pivotL = pivots[1];
    if((k >= pivotS) && (k <= pivotL)) return arr[pivotS];
    if(k > pivotL) return quickselectH(arr, pivotL, right, k);
    else return quickselectH(arr, left, pivotS, k);
  }
  public static int[] quicksort(int[] data){
    quicksortH(data, 0, data.length - 1); //check if this has to be length - 1
    return data;
  }
  public static int[] quicksortH(int[] arr, int left, int right){
    if(left < right){
      int[] ind = part(arr, left, right);
      quicksortH(arr, ind[1] + 1, right); 
      quicksortH(arr, left, ind[0] - 1);
    }
    return arr;
  }
}