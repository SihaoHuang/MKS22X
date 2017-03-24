import java.lang.Math;
import java.util.Arrays;
public class Merge{

  public static void mergesort(int[] ary) {
    if(ary.length <= 1) return;
    int[] left = new int[ary.length/2];
    int[] right = new int[ary.length - ary.length/2];
    for(int i = 0; i < ary.length/2; i ++){
      left[i] = ary[i];
    }
    for(int i = (ary.length - ary.length/2 - 1); i < ary.length; i ++){
      right[i - (ary.length - ary.length/2 - 1)] = ary[i];
    }
    mergesort(left);
    mergesort(right);
    int a = 0; //index for the first array
    int b = 0; //index for the second array
    int i = 0; //index for the large array
    while((a < left.length) && (b < right.length)){
      while(left[a] <= right[b]){
        ary[i] = left[a];
        i ++;
        a ++;
      }
      while(left[a] >= right[b]){
        ary[i] = right[b];
        i ++;
        b ++;
      }
    }
    if(left.length > right.length){
      chop off the end
    }
    if(right.length > left.length){
      chop off the end
    }
    chop off the end of the longer array, add it to the end
  }

  public static void main(String[] args){
    int[] test = {0,1,2,3,4,5,6};
    mergesort(test);
  }

}