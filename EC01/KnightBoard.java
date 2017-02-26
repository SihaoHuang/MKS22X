import java.util.Arrays;
import java.lang.Math;
public class KnightBoard{
  private int[][] board;
  private int[][] possible;
  private int[] rowOrder = {2,1,-1,-2,-2,-1,1,2};
  private int[] colOrder = {1,2,2,1,-1,-2,-2,-1};
  private int[][] matrix;

  public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
    matrix = new int[startingRows][startingCols];
  }

  private void generateMatrix(){
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

  public void solveFast(){
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
        //System.out.println(toString());
        int i = findSmallest(queue);
        //System.out.println(i);
        if(solveFastH(row + rowOrder[i], col + colOrder[i], id + 1)) return true;
      }
      board[row][col] = 0;
    }
    return false;
  }

  private int[] generateQueue(int row, int col){ //clockwise, starting from 1 o clock direction
    int[] out = new int[8];
    for(int i = 0; i < 8; i ++){
      if(((row + rowOrder[i]) >= 0) && ((row + rowOrder[i]) < board.length) && ((col + colOrder[i]) >= 0) && ((col + colOrder[i]) < board[0].length)){
        out[i] = matrix[row + rowOrder[i]][col + colOrder[i]];
      }
      else out[i] = 0;
    }
    return out;
  }

  public int findSmallest(int[] in){
    int smallestInd = 0;
    for(int i = 0; i < 8; i++){
      if((in[i] != 0) && ((in[i] < in[smallestInd]) || (in[smallestInd] == 0))){
        smallestInd = i;
      }
    }
    in[smallestInd] = 0;
    return smallestInd;
  }

  public boolean isEmptyArray(int[] in){
    for(int each:in){
      if(each != 0) return false;
    }
    return true;
  }

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

  public String matrixToString(){
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
    KnightBoard test = new KnightBoard(11,11);
    //test.generateMatrix();
    //System.out.println(test.matrixToString());
    test.solveFast();
    System.out.println(test.toString());
    //System.out.println(Arrays.toString(test.generateQueue(0,0)));
  }

  public String name(){
      return "Huang,Sihao";
  }

}

/*
Optimization:
Code the array with the number of options for movement. Update that as you move. Prioritize moves based on smallest. Initialize an extra array.
2 3 4 4 4 3 2
3 4 6 6 6 4 3
4 6 5 5 5 6 4
4 6 5 5 5 6 4 
4 6 5 5 5 6 4 
3 4 6 6 6 4 3
2 3 4 4 4 3 2
*/




