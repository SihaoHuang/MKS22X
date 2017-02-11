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
    public boolean solve(){
	    return solveH(0);
    }

    private boolean solveH(int col){
      //base cases
      if(col == board.length && hasPlaceable()){
        solutionCount ++;
        return true; //this is okay as the last col will have one unique solution for each set of conditions
      }
      if(col == board.length && hasPlaceable()){
        return false;
      }
      //recursive call
      else{
        for(int row = 0; row < board.length; row ++){
          placeQueen(row, col);
          solveH(col+1);
          removeQueen;
        }
      }
    }

    private boolean placeQueen(int row, int col){
      if(board[row][col] == 0){
        //adds rows
        for(int r = 0; r < board.length; r ++){
          board[r][col] ++;
        }
        //adds column
        for(int c = 0; c < board.length; c ++){
          board[row][c] ++;
        }
        //adds +m diagonal
        for(i<width) {grid[i,-i] ++}
        //adds -m diagonal
        for(i<width) {grid[i,i] ++}
        square == -1; //do last
      }
      if(square == 0){ //do last. We are doing this instead of having it as -1 to recover original state
        square = -1;
      }
      else{
        square = -(original+1); 
      }
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
      for(int row = 0; row < board.length; row ++){
        if(placeQueen(row, col)){ 
          removeQueen(row, col);
          return true; 
        }
      }
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	if (solutionCount == 0) return -1;
      else return solutionCount;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }

    public static String name(){
      return "Huang,Sihao";
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