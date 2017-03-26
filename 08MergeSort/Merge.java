import java.lang.Math;
import java.util.Arrays;
public class Merge{

  public static void mergesort(int[] ary) {
    if(ary.length <= 1) return; //exit condition
    //split array into 2
    int[] left = new int[ary.length/2];
    int[] right = new int[ary.length - ary.length/2];
    int aryIndex = 0;
    for(; aryIndex < ary.length/2; aryIndex ++){
      left[aryIndex] = ary[aryIndex];
    }
    int rightIndex = 0;
    for(; aryIndex < ary.length; aryIndex ++){
      right[rightIndex] = ary[aryIndex];
      rightIndex ++;
    }

    //recursive calls
    mergesort(left);
    mergesort(right);
    //merge in order
    int a = 0; //index for the first array
    int b = 0; //index for the second array
    for(int i = 0; i < ary.length; i ++){
      if(b == right.length){
        ary[i] = left[a];
        a ++;
      }
      else if(a == left.length){
        ary[i] = right[b];
        b ++;
      }
      else if(left[a] < right[b]){
        ary[i] = left[a];
        a ++;
      }
      else{
        ary[i] = right[b];
        b ++;
      }
    }
  }
  
  public static void main(String[] args){
    int[] test = {4,2,4,1,2,1};
    mergesort(test);
    System.out.println(Arrays.toString(test));
  }
}