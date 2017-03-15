import java.util.Random;
public class Quick{
  public static int part(int[] data, int start, int end){
    randgen = new Random();
    int pivotInd = randgen.nextInt(start, end);
    int pivot = data[pivotInd];
    push pivot to end;
    for(int i = start; i < end - 1; i ++){
      if(data[i] > pivot) push data[i] the end;
    }
    //-When done returns the index of the final position of the pivot element.      
    //    (Should be from start to end inclusive)
  }

  public static int quickselect(int[] data, int k){

  }

  public static void main()

}