public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	    board = new int[size][size];
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
    	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
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
private boolean solveH(int col){
  //base case
  if(col == widthOfBoard && hasPlaceable()) return true; //this is okay as the last col will have one unique solution for each set of conditions
  //recursive call
  for(each in col){
    if(placeQueen(eachX, eachY) && solveH(col+1)) count ++;
  }
}

private boolean placeQueen(int x, int y){
  if(squareIsEmpty){
    //adds rows
    for(each in row) {each ++}
    //adds column
    for(each in column) {each ++}
    //adds +m diagonal
    for(i<width) {grid[i,-i] ++}
    //adds -m diagonal
    for(i<width) {grid[i,i] ++}
    square == -1; //do last
  }
  else return false;
}

private boolean hasPlaceable(col){
  for(each in col){
    if(placeQueen(eachX, eachY)) return true; 
  }
}

*************************/