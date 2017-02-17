public class KnightBoard{
  private int[][] board;
  private int[] rowOrder = {1,-1,2,2,1,-1,-2,-2};
  private int[] colOrder = {2,2,1,-1,-2,-2,1,-1};

  public KnightBoard(int startingRows,int startingCols){
    board = new int[startingRows][startingCols];
  }

  public void solve(){
    System.out.println(solveH(0,0,1));
  }
  private boolean solveH(int row, int col, int id){
    if(board.length*board[0].length + 1 == id) return true;
    if(board[row][col] == 0){
      board[row][col] = id;
      for(int i = 0; i < 8; i ++){ 
        //System.out.println(i);
        if(((row + rowOrder[i]) >= 0) && ((row + rowOrder[i]) < board.length) && ((col + colOrder[i]) >= 0) && ((col + colOrder[i]) < board[0].length)){
          //System.out.println(toString());
          if(solveH(row + rowOrder[i], col + colOrder[i], id + 1)) return true;
        }
      }
      board[row][col] = 0;
    }
    return false;
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

  public static void main(String[] arg){
    KnightBoard test = new KnightBoard(8,8);
    test.solve();
    System.out.println(test.toString());
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