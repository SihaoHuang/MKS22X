public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	    board = new int[size][size];
      solutionCount = 0;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void countSolutions(){
	    countSolutionsH(0);
    }

    public void solve(){
      solveH(0);
      int ifSolved = 0;
      for(int each:board[0]){
        if(each != 0) ifSolved ++;
      }
      if(ifSolved > 0){
        for(int i = 0; i < board.length; i ++){
          if(board[i][board.length - 1] == 0) board[i][board.length - 1] = -1;
        }
      }
    }

    private boolean solveH(int col){
      if(col == board.length - 1 && hasPlaceable(col)){
        return true; //this is okay as the last col will have one unique solution for each set of conditions
      }
      if(col == board.length - 1 && !hasPlaceable(col)){
        return false;
      }
      //recursive call
      else{
        for(int row = 0; row < board.length; row ++){
          if (placeQueen(row, col)){
            if (!solveH(col+1)) removeQueen(row, col);
            else return true; //quit loop
          }
        }
        return solutionCount != 0;
      }
    }

    private boolean countSolutionsH(int col){
      //System.out.println(toString());
      //base cases
      //System.out.println("on column "+col);
      if(col == board.length - 1 && hasPlaceable(col)){
        solutionCount ++;
        //System.out.println("triggered true");
        return true; //this is okay as the last col will have one unique solution for each set of conditions
      }
      if(col == board.length - 1 && !hasPlaceable(col)){
        //System.out.println("triggered false");
        return false;
      }
      //recursive call
      else{
        for(int row = 0; row < board.length; row ++){
          if (placeQueen(row, col)){
            countSolutionsH(col+1);
            removeQueen(row, col);
          }
        }
        return solutionCount != 0;
      }
    }

    private boolean placeQueen(int row, int col){
      //System.out.println(row);
      //System.out.println(col);
      if(board[row][col] == 0){
        //adds rows
        for(int r = 0; r < board.length; r ++){
          board[r][col] ++;
        }
        //adds column
        for(int c = 0; c < board.length; c ++){
          board[row][c] ++;
        }
        //adds -m diagonal
        for(int increment = 0; ((row + increment) != board.length) && ((col + increment) != board.length) ; increment ++){
          board[row + increment][col + increment] ++;
        }
        for(int decrement = 0; ((row - decrement) >= 0) && ((col - decrement) >= 0) ; decrement ++){
          board[row - decrement][col - decrement] ++;
        }
        //adds +m diagonal
        for(int increment = 0; ((row - increment) >= 0) && ((col + increment) != board.length) ; increment ++){
          board[row - increment][col + increment] ++;
        }
        for(int decrement = 0; ((row + decrement) != board.length) && ((col - decrement) >= 0) ; decrement ++){
          board[row + decrement][col - decrement] ++;
        }
        board[row][col] = -1;
        return true;
      }
      else return false;
    }

    private void removeQueen(int row, int col){
        for(int r = 0; r < board.length; r ++){
          board[r][col] --;
        }
        //adds column
        for(int c = 0; c < board.length; c ++){
          board[row][c] --;
        }
        //adds -m diagonal
        for(int increment = 0; ((row + increment) != board.length) && ((col + increment) != board.length) ; increment ++){
          board[row + increment][col + increment] --;
        }
        for(int decrement = 0; ((row - decrement) >= 0) && ((col - decrement) >= 0) ; decrement ++){
          board[row - decrement][col - decrement] --;
        }
        //adds +m diagonal
        for(int increment = 0; ((row - increment) >= 0) && ((col + increment) != board.length) ; increment ++){
          board[row - increment][col + increment] --;
        }
        for(int decrement = 0; ((row + decrement) != board.length) && ((col - decrement) >= 0) ; decrement ++){
          board[row + decrement][col - decrement] --;
        }
        board[row][col] = 0;
    }

    private boolean hasPlaceable(int col){
      for(int row = 0; row < board.length; row ++){
        if (board[row][col] == 0) return true; 
      }
      return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	if(solutionCount == 0){
        return -1;
      }
      else{
        return solutionCount;
      }
    }
    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
      String output = "";
      for(int[] row:board){
        for(int each:row){
          if(each == -1) output += "Q ";
          else output += "_ ";
        }
        output += "\n";
      }
    	return output;
    }

    public String name(){
      return "Huang,Sihao";
    }

    public static void main(String[] args){
      QueenBoard test = new QueenBoard(30);
      // test.placeQueen(5,4);
      // test.placeQueen(3,3);
      // test.toString();
      // test.removeQueen(5,4);
      // test.removeQueen(3,3);
      // System.out.println("here");
      // System.out.println(test.toString());
      test.solve();
      System.out.println(test.toString());
      //System.out.println(test.toString());
    }
}

/********** PSEUDOCODE **********
 * 
private boolean solveH(int col){       //REMEMEBR THE RETURN FALSE CASE
  //base case
  if(col == widthOfBoard && hasPlaceable()) {
    count ++;
    return true; //this is okay as the last col will have one unique solution for each set of conditions
  }
  //recursive call
  for(each in col){
    placeQueen(eachX, eachY);
    solveH(col+1);
    removeQueen;
  }
}

private boolean placeQueen(int row, int col){
  if(squareIsEmpty){
    //adds rows
    for(each in row) {each ++}
    //adds column
    for(each in column) {each ++}
    //adds +m diagonal
    for(i<width) {grid[i,-i] ++}
    //adds -m diagonal
    for(i<width) {grid[i,i] ++}
    if(square == 0){ //do last. We are doing this instead of having it as -1 to recover original state
      square = -1;
    }
    else{
      square = -(original+1); 
    }
  }
  else return false;
}

private void removeQueen(int row, int col){
  for(each in row) {each --}
  for(each in column) {each --}
  for(i<width) {grid[i,-i] --}
  for(i<width) {grid[i,i] --}
  if(square == -1){ //recovers the original state. Note all negative integers denote the presence of a queen
      square == 0;
  }
  else{
    square = -(original+1); 
  }
  square = -1; 
}

private boolean hasPlaceable(col){
  for(each in col){
    if(placeQueen(eachX, eachY)){
      removeQueen(row,col);
      return true;
    }   
  }
}

*************************/