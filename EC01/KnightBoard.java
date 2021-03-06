import java.util.Arrays;
import java.lang.Math;

//NOTE: this implementation of the Warnsdorff's rule works as intended when printed out/animated, but it does not work for boards 11*11 and above. I tried profiling each of the functions but there doesnt seem to be a significant issue.
public class KnightBoard{
  private int[][] board;
  private int[][] matrix;
  private int[] rowOrder = {2,1,-1,-2,-2,-1,1,2};
  private int[] colOrder = {1,2,2,1,-1,-2,-2,-1};
  private static long genQueElapsedTime;
  private static long findSmallElapsedTime;

  public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    matrix = new int[startingRows][startingCols];
  }

  private void generateMatrix(){ //creates matrix with squares filled with the number of possible moves each can make. This runs fast.
    for(int row = 0; row < board.length; row ++){
      for(int col = 0; col < board[0].length; col ++){
        int count = 0;
        for(int i = 0; i < 8; i ++){
          if(((row + rowOrder[i]) >= 0) && ((row + rowOrder[i]) < board.length) && ((col + colOrder[i]) >= 0) && ((col + colOrder[i]) < board[0].length)){
            count ++;
          }
        }
        matrix[row][col] = count;
      }
    }
  }

  public void solveFast(){ //helper function, matrix is generated first
    generateMatrix();
    solveFastH(0,0,1);
  }

  private boolean solveFastH(int row, int col, int id){
    if(board.length*board[0].length + 1 == id) return true;
    if(board[row][col] == 0){
      board[row][col] = id;
      int[] queue = generateQueue(row, col);
      //System.out.println(Arrays.toString(queue));
      while(!isEmptyArray(queue)){
        System.out.println(toString());
        int i = findSmallest(queue);
        //System.out.println("genQueue is " + genQueElapsedTime);
        //System.out.println("findSmallest is " + findSmallElapsedTime);
        //System.out.println(i);
        if(solveFastH(row + rowOrder[i], col + colOrder[i], id + 1)) return true;
      }
      board[row][col] = 0;
    }
    return false;
  }

/******************************************************AUX FUNCTIONS****************************************************************/
  private int[] generateQueue(int row, int col){ //Generates a queue of moves surrounding a square clockwise, starting from 1 o clock direction. Constant time!
    //long genQueStart = System.nanoTime();  
    int[] out = new int[8];
    for(int i = 0; i < 8; i ++){
      if(((row + rowOrder[i]) >= 0) && ((row + rowOrder[i]) < board.length) && ((col + colOrder[i]) >= 0) && ((col + colOrder[i]) < board[0].length)){
        out[i] = matrix[row + rowOrder[i]][col + colOrder[i]];
      }
      else out[i] = 0;
    }
    //genQueElapsedTime = System.nanoTime() - genQueStart;
    return out;
  }

  public static int findSmallest(int[] in){ //Finds the smallest number in the queue, returns it so solveFastH can attempt it first, and then sets that to zero. Constant time!
    //long findSmallStart = System.nanoTime();
    int smallestInd = 0;
    for(int i = 0; i < 8; i++){
      if((in[i] != 0) && ((in[i] < in[smallestInd]) || (in[smallestInd] == 0))){
        smallestInd = i;
      }
    }
    in[smallestInd] = 0;
    //findSmallElapsedTime = System.nanoTime() - findSmallStart;
    return smallestInd;
  }

  public boolean isEmptyArray(int[] in){ //If the queue is empty, stop.
    for(int each:in){
      if(each != 0) return false;
    }
    return true;
  }

/******************************************************AUX FUNCTIONS****************************************************************/

  public String toString(){
    String output = "";
      for(int[] row:board){
        for(int each:row){
          if(each < 0) output += " " + each + " ";
          else if(each < 10) output += " " + each + " ";
          else output += each + " ";
        }
        output += "\n";
      }
    	return output;
  }

  public String matrixToString(){ //Debug function
    String output = "";
      for(int[] row:matrix){
        for(int each:row){
          if(each < 0) output += " " + each + " ";
          else if(each < 10) output += " " + each + " ";
          else output += each + " ";
        }
        output += "\n";
      }
    	return output;
  }

  public static void main(String[] arg){
    KnightBoard test = new KnightBoard(10,10);
    //test.generateMatrix();
    //System.out.println(test.matrixToString());
    test.solveFast();
    System.out.println(test.toString());
  }

  public String name(){
      return "Huang,Sihao";
  }

}



